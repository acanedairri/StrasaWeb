package org.strasa.web.view.model;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.strasa.middleware.manager.CreateFieldBookManagerImpl;
import org.strasa.middleware.manager.LocationManagerImpl;
import org.strasa.middleware.manager.PlantingTypeManagerImpl;
import org.strasa.middleware.manager.StudyDataDynamicColumnManager;
import org.strasa.middleware.manager.StudyManagerImpl;
import org.strasa.middleware.manager.StudyVariableManagerImpl;
import org.strasa.middleware.model.Location;
import org.strasa.middleware.model.PlantingType;
import org.strasa.middleware.model.Study;
import org.strasa.middleware.model.StudyVariable;
import org.strasa.middleware.model.custom.StudyDataDynamicColumnQueryBuilder;
import org.strasa.web.createfieldbook.view.model.CreateFieldBookException;
import org.strasa.web.createfieldbook.view.pojos.CreateFieldBookThread;
import org.strasa.web.createfieldbook.view.pojos.SiteInformationModel;
import org.strasa.web.crossstudyquery.view.model.AcrossStudyData;
import org.strasa.web.utilities.FileUtilities;
import org.zkoss.bind.BindContext;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Messagebox;

public class UploadTemplateSimulator {

	String studyName;
	Integer totalUsers;
	Integer uploadPerUser;
	Integer sitePerStudy;
	Integer variatePerStudy;
	File fileGenotype;
	File fileLayout;
	ArrayList<String> elapses = new ArrayList<String>();
	List<Location> lstLocations = new LocationManagerImpl().getAllLocations();

	List<StudyVariable> lstStuVariable = new StudyVariableManagerImpl().getVariableByDataType("N",
			new ArrayList<String>(Arrays.asList("AMY", "AWNING", "AN", "CLK", "CMD", "CML", "CMST", "DTF", "DTH", "DTM", "DRR", "DRRE", "DRS", "FTP", "FTL", "FTP", "FLA", "GELC", "GELT", "GRL", "GRM", "GRS", "GRT")));
	CreateFieldBookManagerImpl flbookMan = new CreateFieldBookManagerImpl();
	ArrayList<ReportModel> lstGenerationReport = new ArrayList<UploadTemplateSimulator.ReportModel>();
	ArrayList<ReportModel> lstUploadReport = new ArrayList<UploadTemplateSimulator.ReportModel>();

	ArrayList<File> lstFileGenerated = new ArrayList<File>();

	@Init
	public void init() {

	}

	@AfterCompose
	public void afterCompose(@ContextParam(ContextType.BIND_CONTEXT) BindContext ctx, @ContextParam(ContextType.VIEW) Component view) {

		// ArrayList<ArrayList<String>> lstDynaColTest = new
		// StudyDataDynamicColumnManager().getStudyRawDataDynaCols(139, null, 0,
		// 10);

		StudyDataDynamicColumnQueryBuilder sqlBuilder = new StudyDataDynamicColumnQueryBuilder(true);
		sqlBuilder.andEqualTo("CMD", "200").andEqualTo("AMY", "200");
		ArrayList<AcrossStudyData> lstResult = new StudyDataDynamicColumnManager(true).getAcrossStudyResult(sqlBuilder);
		for (AcrossStudyData res : lstResult) {
			System.out.println(res.toString());
		}
	}

	@NotifyChange("*")
	@Command("uploadTemplates")
	public void uploadTemplates() {

		for (File template : lstFileGenerated) {
			try {
				Integer userID = Integer.parseInt(template.getName().split("_")[1]);
				long startTime = System.nanoTime();
				new CreateFieldBookManagerImpl().populateStudyFromTemplate(template, userID, true, template.getName());
				Clients.clearBusy();
				Messagebox.show("Fieldbook successfully uploaded!", "Uploading Fieldbook", Messagebox.OK, org.zkoss.zul.Messagebox.INFORMATION);

				long elapsedTime = System.nanoTime() - startTime;
				lstUploadReport.add(new ReportModel(template.getName(), String.valueOf(((double) (elapsedTime / 1000000000)))));

			} catch (CreateFieldBookException e) {
				// TODO Auto-generated catch block
				Clients.clearBusy();
				Messagebox.show(e.getMessage(), "Error in Fieldbook", Messagebox.OK, org.zkoss.zul.Messagebox.EXCLAMATION);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {

			}
		}
	}

	@NotifyChange("*")
	@Command("generate")
	public void generate() {
		lstFileGenerated.clear();
		lstGenerationReport.clear();
		PlantingType plantingType = new PlantingTypeManagerImpl().getPlantingTypeById(1);
		File outputFolder = new File(Executions.getCurrent().getDesktop().getWebApp().getRealPath("/") + "ExcelOutput/Simulations");
		ArrayList<StudyVariable> studyvar = new ArrayList<StudyVariable>();
		for (int i = 0; i < variatePerStudy; i++) {
			studyvar.add(lstStuVariable.get(i));
		}

		if (!outputFolder.exists())
			outputFolder.mkdirs();
		ArrayList<SiteInformationModel> lstSiteInfo = new ArrayList<SiteInformationModel>();

		for (int a = 1; a <= totalUsers; a++) {

			for (int b = 1; b <= uploadPerUser; b++) {
				long startTime = System.nanoTime();
				;
				Study study = new Study();
				study.setName(studyName + "_" + a + "_" + b);
				study.setDescription(studyName + "_" + a + "_" + b);
				study.setEndyear("2014");
				study.setProgramid(1);
				study.setProjectid(1);
				study.setShared(true);
				study.setUserid(a);
				study.setStartyear("2014");
				study.setStudytypeid(1);
				lstSiteInfo.clear();
				for (int c = 1; c <= sitePerStudy; c++) {
					SiteInformationModel siteInfo = new SiteInformationModel();
					siteInfo.getAgronomy().setDensity("Den1");
					siteInfo.getAgronomy().setFertilization("Fert1");
					siteInfo.getAgronomy().setPlantingtypeid(1);
					siteInfo.getAgronomy().setSowingdate(this.addDays(new Date(), 1));
					siteInfo.getAgronomy().setHarvestdate(this.addDays(new Date(), 20));
					siteInfo.setPlantingtype(plantingType);

					siteInfo.getDesign().setDesignfactor1("Design1");
					siteInfo.getDesign().setDesignfactor2("Design2");
					siteInfo.getDesign().setDesignfactor3("Design3");
					siteInfo.getDesign().setPlotsize("100");
					siteInfo.getDesign().setDesignstructure("CRD");
					siteInfo.getDesign().setTreatmentstructure("Treat1");

					siteInfo.setSitename("Site " + c);
					siteInfo.setLocation(lstLocations.get(randInt(1, lstLocations.size() - 1)));
					siteInfo.setYear("2014");
					siteInfo.setSeason("DS");
					siteInfo.setEcotypeid(1);
					siteInfo.setSoiltype("SoilType1");
					siteInfo.setSoilph("7.1pH");
					siteInfo.setFileGenotype(fileGenotype);
					siteInfo.setFileLayout(fileLayout);

					siteInfo.lstStudyVariable.clear();
					siteInfo.lstStudyVariable.addAll(studyvar);
					System.out.println("Tot: " + siteInfo.lstStudyVariable.size());
					lstSiteInfo.add(siteInfo);
				}

				new StudyManagerImpl().insertStudy(study);

				CreateFieldBookThread cfThread = new CreateFieldBookThread() {

					@Override
					public void updateUI(String msg) {
						// TODO Auto-generated method stub
						System.out.println(msg);
						// ((Label) view.getFellow("lblbusybox")).setValue(msg);
						;

					}

					@Override
					public void onError(String errorMsg) {
						// TODO Auto-generated method stub
						System.out.println(errorMsg);
						Messagebox.show(errorMsg, "Error in creating Fieldbook", Messagebox.OK, Messagebox.EXCLAMATION);
					}

					@Override
					public void onFinish(File outputFile) {
						// TODO Auto-generated method stub
						lstFileGenerated.add(outputFile);
						Clients.clearBusy();

					}

					@Override
					public void onStart() {

					}
				};
				System.out.println(outputFolder.getAbsolutePath());
				CreateFieldBookManagerImpl createFieldBookMan = new CreateFieldBookManagerImpl(lstSiteInfo, study, outputFolder, cfThread, true);
				try {
					createFieldBookMan.generateFieldBook();
				} catch (CreateFieldBookException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				long elapsedTime = System.nanoTime() - startTime;
				lstGenerationReport.add(new ReportModel(study.getName(), String.valueOf(((double) (elapsedTime / 1000000000)))));
			}

		}
	}

	@Command("uploadGenotype")
	public void uploadGenotype(@ContextParam(ContextType.BIND_CONTEXT) BindContext ctx, @ContextParam(ContextType.VIEW) Component view) {

		File tempFile = FileUtilities.getFileFromUpload(ctx, view);
		if (tempFile == null)
			return;
		fileGenotype = tempFile;

	}

	@Command("uploadLayout")
	public void uploadLayout(@ContextParam(ContextType.BIND_CONTEXT) BindContext ctx, @ContextParam(ContextType.VIEW) Component view) {

		File tempFile = FileUtilities.getFileFromUpload(ctx, view);
		if (tempFile == null)
			return;

		fileLayout = tempFile;
	}

	public String getStudyName() {
		return studyName;
	}

	public void setStudyName(String studyName) {
		this.studyName = studyName;
	}

	public Integer getTotalUsers() {
		return totalUsers;
	}

	public void setTotalUsers(Integer totalUsers) {
		this.totalUsers = totalUsers;
	}

	public Integer getUploadPerUser() {
		return uploadPerUser;
	}

	public void setUploadPerUser(Integer uploadPerUser) {
		this.uploadPerUser = uploadPerUser;
	}

	public File getFileGenotype() {
		return fileGenotype;
	}

	public void setFileGenotype(File fileGenotype) {
		this.fileGenotype = fileGenotype;
	}

	public File getFileLayout() {
		return fileLayout;
	}

	public void setFileLayout(File fileLayout) {
		this.fileLayout = fileLayout;
	}

	public ArrayList<String> getElapses() {
		return elapses;
	}

	public void setElapses(ArrayList<String> elapses) {
		this.elapses = elapses;
	}

	public Integer getSitePerStudy() {
		return sitePerStudy;
	}

	public void setSitePerStudy(Integer sitePerStudy) {
		this.sitePerStudy = sitePerStudy;
	}

	public Integer getVariatePerStudy() {
		return variatePerStudy;
	}

	public void setVariatePerStudy(Integer variatePerStudy) {
		this.variatePerStudy = variatePerStudy;
	}

	public static Date addDays(Date date, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days); // minus number would decrement the days
		return cal.getTime();
	}

	public static int randInt(int min, int max) {

		// NOTE: Usually this should be a field rather than a method
		// variable so that it is not re-seeded every call.
		Random rand = new Random();

		// nextInt is normally exclusive of the top value,
		// so add 1 to make it inclusive
		int randomNum = rand.nextInt((max - min) + 1) + min;

		return randomNum;
	}

	public class ReportModel {
		String studyname;
		String elapseTime;
		public File template;

		public ReportModel(String s, String e) {
			studyname = s;
			elapseTime = e;
		}

		public String getStudyname() {
			return studyname;
		}

		public void setStudyname(String studyname) {
			this.studyname = studyname;
		}

		public String getElapseTime() {
			return elapseTime;
		}

		public void setElapseTime(String elapseTime) {
			this.elapseTime = elapseTime;
		}

	}

	public ArrayList<ReportModel> getLstGenerationReport() {
		return lstGenerationReport;
	}

	public void setLstGenerationReport(ArrayList<ReportModel> lstGenerationReport) {
		this.lstGenerationReport = lstGenerationReport;
	}

	public ArrayList<ReportModel> getLstUploadReport() {
		return lstUploadReport;
	}

	public void setLstUploadReport(ArrayList<ReportModel> lstUploadReport) {
		this.lstUploadReport = lstUploadReport;
	}
}
