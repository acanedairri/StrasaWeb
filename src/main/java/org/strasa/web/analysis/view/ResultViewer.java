package org.strasa.web.analysis.view;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.analysis.rserve.manager.RServeManager;
import org.apache.commons.io.input.ReaderInputStream;
import org.spring.security.model.SecurityUtil;
import org.strasa.web.analysis.result.view.model.FileComposer;
import org.strasa.web.analysis.result.view.model.FileModel;
import org.strasa.web.analysis.result.view.model.FileModelTreeNode;
import org.strasa.web.analysis.view.model.SingleSiteAnalysisModel;
import org.strasa.web.utilities.FileUtilities;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.util.media.AMedia;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Div;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.Include;
import org.zkoss.zul.Separator;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;
import org.zkoss.zul.Treeitem;

import au.com.bytecode.opencsv.CSVReader;

public class ResultViewer {	
	private RServeManager rServeManager;
	String textFileContent = null;
	private AMedia fileContent;
	private File tempFile;
	private static final String IMAGE_THUMBNAIL_HEIGHT = "150px";
	private static final String IMAGE_THUMBNAIL_WIDTH = "150px";
	private static final String FILE_SEPARATOR  = System.getProperty("file.separator");
	private static String RESULT_ANALYSIS_PATH=(Sessions.getCurrent().getWebApp().getRealPath("resultanalysis")).replaceAll("\\\\", "/");

	@AfterCompose
	public void init(@ContextParam(ContextType.COMPONENT) final Component component,
			@ContextParam(ContextType.VIEW) Component view, @ExecutionArgParam("outputFolderPath") String outputFolderPath){
		StringBuilder sb = new StringBuilder();
		System.out.println("outputFolder REsult Analysis:" + outputFolderPath);

		//outputTextViewer
		File outputFolder = new File(outputFolderPath);
		if(outputFolder.isDirectory()){
			System.out.println("folder: "+outputFolderPath);
			String[] files = outputFolder.list();
			for(String file: files){
				System.out.println("display: "+file);
				if(file.endsWith(".txt")){
					Tabpanel txtResultPanel = (Tabpanel) component.getFellow("txtResultTab");
					File fileToCreate = new File(outputFolderPath+file);
					byte[] buffer = new byte[(int) fileToCreate.length()];
					FileInputStream fs;
					try {
						fs = new FileInputStream(fileToCreate);
						fs.read(buffer);
						fs.close();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					ByteArrayInputStream is = new ByteArrayInputStream(buffer);
					AMedia fileContent = new AMedia("report", "text", "text/plain", is);
					Include studyInformationPage = new Include();
					studyInformationPage.setParent(txtResultPanel);
					studyInformationPage.setDynamicProperty("txtFile", fileContent);
					studyInformationPage.setSrc("/user/analysis/txtviewer.zul");
					sb.append("txt");
				}
				if(file.endsWith(".png")){
					Div div = (Div) component.getFellow("graphResultDiv");
					final String path = outputFolderPath.replace(RESULT_ANALYSIS_PATH, "/resultanalysis").trim()+file;
										System.out.println("display image:" + RESULT_ANALYSIS_PATH);
					final Groupbox newGroupBox = new Groupbox();
					//					newGroupBox.setStyle("overflow: auto");
					newGroupBox.setTitle(file.replaceAll(".csv", ""));
					newGroupBox.setHeight(IMAGE_THUMBNAIL_HEIGHT);
					newGroupBox.setWidth(IMAGE_THUMBNAIL_WIDTH);
					newGroupBox.setClosable(false);
					
					newGroupBox.addEventListener(Events.ON_CLICK, new EventListener<Event>() {
						@Override
						public void onEvent(Event event) throws Exception {
							zoomImage(path.replaceAll("\\\\", "//"), component);
						}
					});
					
					Include studyInformationPage = new Include();
					studyInformationPage.setDynamicProperty("height", IMAGE_THUMBNAIL_HEIGHT);
					studyInformationPage.setDynamicProperty("width", IMAGE_THUMBNAIL_WIDTH);
					studyInformationPage.setDynamicProperty("imageName", path.replaceAll("\\\\", "//"));
					studyInformationPage.setSrc("/user/analysis/imgviewer.zul");
					studyInformationPage.setParent(newGroupBox);
					System.out.println("imgPath "+path);
					div.appendChild(newGroupBox);
					Separator sep = new Separator();
					sep.setHeight("30px");
					div.appendChild(sep);
					sb.append(".png");
				}
				if(file.endsWith(".csv") && !file.contains("(dataset)")){
					System.out.println("display image:" + outputFolderPath+file);
					Tabpanel tabPanel = (Tabpanel) component.getFellow("csvResultTab");

					Groupbox newGroupBox = new Groupbox();
					//					newGroupBox.setStyle("overflow: auto");
					newGroupBox.setTitle(file.replaceAll(".csv", ""));
					newGroupBox.setMold("3d");
					newGroupBox.setHeight("500px");
					String path = outputFolderPath+file;
					File fileToCreate = new File(path);

					byte[] buffer = new byte[(int) fileToCreate.length()];
					FileInputStream fs;
					try {
						fs = new FileInputStream(fileToCreate);
						fs.read(buffer);
						fs.close();
						tempFile = File.createTempFile("csvdata", ".tmp");
						ByteArrayInputStream is = new ByteArrayInputStream(buffer);
						fileContent = new AMedia("report", "text", "text/plain", is);
						InputStream in = fileContent.isBinary() ? fileContent.getStreamData() : new ReaderInputStream(fileContent.getReaderData());
						FileUtilities.uploadFile(tempFile.getAbsolutePath(), in);

						CSVReader reader = new CSVReader(new FileReader(tempFile.getAbsolutePath()));
						Include studyInformationPage = new Include();
						studyInformationPage.setDynamicProperty("csvReader", reader);
						studyInformationPage.setDynamicProperty("name", file.replaceAll(".csv", ""));
						studyInformationPage.setSrc("/user/analysis/csvviewer.zul");

						studyInformationPage.setParent(newGroupBox);
						tabPanel.appendChild(newGroupBox);

						Separator sep = new Separator();
						sep.setHeight("20px");
						tabPanel.appendChild(sep);
						sb.append("csv");
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//					treeTabs.appendChild(newTab);
				}
				if(file.endsWith("(dataset).csv")){
					System.out.println("display image:" + outputFolderPath+file);
					Tabpanel tabPanel = (Tabpanel) component.getFellow("dataSetTab");

					Groupbox newGroupBox = new Groupbox();
					newGroupBox.setTitle(file.replaceAll(".csv", ""));
					newGroupBox.setMold("3d");
					newGroupBox.setHeight("500px");
					String path = outputFolderPath+file;
					File fileToCreate = new File(path);

					byte[] buffer = new byte[(int) fileToCreate.length()];
					FileInputStream fs;
					try {
						fs = new FileInputStream(fileToCreate);
						fs.read(buffer);
						fs.close();
						tempFile = File.createTempFile("csvdata", ".tmp");
						ByteArrayInputStream is = new ByteArrayInputStream(buffer);
						fileContent = new AMedia("report", "text", "text/plain", is);
						InputStream in = fileContent.isBinary() ? fileContent.getStreamData() : new ReaderInputStream(fileContent.getReaderData());
						FileUtilities.uploadFile(tempFile.getAbsolutePath(), in);

						CSVReader reader = new CSVReader(new FileReader(tempFile.getAbsolutePath()));
						Include studyInformationPage = new Include();
						studyInformationPage.setDynamicProperty("csvReader", reader);
						studyInformationPage.setDynamicProperty("name", file.replaceAll(".csv", ""));
						studyInformationPage.setSrc("/user/analysis/csvviewer.zul");

						studyInformationPage.setParent(newGroupBox);
						tabPanel.appendChild(newGroupBox);

						Separator sep = new Separator();
						sep.setHeight("20px");
						tabPanel.appendChild(sep);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//					treeTabs.appendChild(newTab);
				}
			}
		}
		String s = sb.toString();
		Tabpanel tabanel = null;
		Tab tab = null;
		if(!s.contains("txt")){
			tabanel = (Tabpanel) component.getFellow("txtResultTab");
			tab = (Tab) component.getFellow("txtResult");
			detach(tabanel,tab);
		}
		if(!s.contains("csv")){
			tabanel = (Tabpanel) component.getFellow("csvResultTab");
			tab = (Tab) component.getFellow("csvResult");
			detach(tabanel,tab);
		}
		if(!s.contains("png")){
			tabanel = (Tabpanel) component.getFellow("graphResultTab");
			tab = (Tab) component.getFellow("graphResult");
			detach(tabanel,tab);
		}

		Tabbox tabBox = (Tabbox) component.getFellow("tabBox");
		tabBox.setSelectedIndex(0);
		
	}

	protected void zoomImage(String dynamicProperty, Component component) {
		// TODO Auto-generated method stub
		Div div = (Div) component.getFellow("zoomDiv");
		if(div.getChildren().size()>0) div.getChildren().get(0).detach();
		
		Include studyInformationPage = new Include();
		studyInformationPage.setDynamicProperty("height", FileComposer.IMAGE_HEIGHT);
		studyInformationPage.setDynamicProperty("width", FileComposer.IMAGE_WIDTH);
		studyInformationPage.setDynamicProperty("imageName", dynamicProperty);
		studyInformationPage.setSrc("/user/analysis/imgviewer.zul");
		studyInformationPage.setParent(div);
		div.appendChild(studyInformationPage);
	}

	private void detach(Tabpanel tabanel, Tab tab) {
		// TODO Auto-generated method stub
			tabanel.detach();
			tab.detach();
	}
}
