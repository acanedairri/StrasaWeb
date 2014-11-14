package org.strasa.web.analysis.view.model;

import org.zkoss.zk.ui.Sessions;

public class QTLAnalysisModel {
	private static String BSLASH = "\\";
	private static String FSLASH = "/";
	private static String OUTPUTFOLDER_PATH =  Sessions.getCurrent().getWebApp().getRealPath("resultanalysis")+ System.getProperty("file.separator")+
			"user2"+ System.getProperty("file.separator")+"Single-Site"+ System.getProperty("file.separator")+"MyResult"+ System.getProperty("file.separator");
	public static String DATA_PATH =  System.getProperty("user.dir")+ System.getProperty("file.separator") + "sample_datasets" + System.getProperty("file.separator");

	private String dataCheckOutFileName; //supply path and name of text file where text output for data quality check is going to be saved

	private String outFileName;	//supply path and name of text file where text output for analysis is going to be saved
	private String resultFolderPath; //supply path where the graphs will be saved "E:/App Fil	es/workspace_Juno/RJavaManager/sample_datasets"
	private String dataFormat; //supply data format used - "default", "R", Map Maker", "Map Manager", "QTL Cartographer" 
	private String format1; //supply format of the first input file, whether "csv", "ctxt", "stxt", "ttxt", or "sctxt" 
	private String crossType; //supply type of cross used, whether "f2", "bc", "risib", "riself", "bcsft"
	private String file1; //supply path and name of first input file
	private String format2; //supply format of the second input file, whether "csv", "ctxt", "stxt", "ttxt", or "sctxt" 
	private String file2; //supply path and name of second input file
	private String format3; //supply format of the third input file, whether "csv", "ctxt", "stxt", "ttxt", or "sctxt" 
	private String file3; //supply path and name of third input filel
	private String P_geno; //supply name of genotype variable
	private int bcNum; //supply bc generation, if crosstype is "bcsft" 
	private int fNum; //supply filial generation, if crosstype is "bcsft"

	//specify parameters
	private boolean doMissing;
	private boolean deleteMiss;
	private double cutOff;
	private boolean doDistortionTest;
	private double pvalCutOff;
	private boolean doCompareGeno;
	private double cutoffP;
	private boolean doCheckMarkerOrder;
	private double lodThreshold;
	private boolean doCheckGenoErrors;
	private double lodCutOff;
	private double errorProb;

	//IM
	private String traitType; //"Ordinal"; //"Continuous"; //c("Continuous", "Binary", "Ordinal"), yVars, //reqd
	private String[] yVars; //{"T264o", "T264o2", "T264o3"}; //{"T264", "T264d", "T264sd"};					//reqd
	private String mMethod; //mMethod = c("IM", "CIM", "MQM", "BM")									//reqd
	private double stepCalc; 																									
	private double errCalc;																									
	private String mapCalc; //c("haldane","kosambi","c-f","morgan")														
	private double lodCutoffM;																				//reqd																									
	private String phenoModel; // "binary"; //"normal";//c("normal","binary","2part","np")														
	private String alMethod;//c("em","imp","hk","ehk","mr","mr-imp","mr-argmax")							//reqd
	private int nPermutations;//100																			//reqd
	private int numCovar; 					//3  	
	private double winSize;				//10
	private String genoName;			//"Geno"
	private boolean threshLiJi;			//true
	private double thresholdNumericalValue; //0 
	private double minDist;				//10-
	private double stepSize;				//5.0
	private boolean addModel;			//true
	private int numCofac;					//1
	private boolean mlAlgo;				//true
	private boolean setupModel; //TRUE																						
	private boolean includeEpistasis; //FALSE																				
	private boolean useDepPrior; //FALSE,																					
	private int priorMain;																										
	private int priorAll;																							
	private String maxQTLs;																								
	private double priorProb;		

	public QTLAnalysisModel() {

		setDataCheckOutFileName(DATA_PATH + "QTL_dataCheck.txt");
		setOutFileName(DATA_PATH + "QTL_output.txt");
		setResultFolderPath(DATA_PATH);  // outputPath = "E:/App Files/workspace_Juno/RJavaManager/sample_datasets"
		setDataFormat("default");
		setFormat1("csv");
		setCrossType ("f2"); 
		setFile1(DATA_PATH + "listeria1_pheno_mv.csv");
		setFormat2("csv");
		setFile2(DATA_PATH + "listeria1_geno.csv");
		setFormat3("csv");
		setFile3(DATA_PATH + "listeria1_map.csv");
		setP_geno("Geno");
		setBcNum(0);
		setfNum(0);

		//		QTLdata <- createQTLdata(outputPath, dataFormat, format1, crossType, file1, format2, file2, format3, file3, 
		//		              P_geno, bcNum, fNum)

		//specify parameters
		setDoMissing(true); //
		setDeleteMiss(true);//
		setCutOff(0.15);
		setDoDistortionTest(true);//
		setPvalCutOff(0.01);
		setDoCompareGeno(true);//
		setCutoffP(0.70);
		setDoCheckMarkerOrder(true);
		setLodThreshold(3);
		setDoCheckGenoErrors(true);
		setLodCutOff(5);
		setErrorProb(0.01); 

		//IM
		setTraitType("Binary"); //"Ordinal"; //"Continuous"; //c("Continuous", "Binary", "Ordinal"), yVars, mMethod = c("IM", "CIM", "MQM", "BM")	//reqd
		//		 yVars = {"T264b", "T264b2"}; //{"T264o", "T264o2", "T264o3"}; //{"T264", "T264d", "T264sd"};																								//reqd
		setmMethod("IM"); 																								//reqd
		setStepCalc(0); 																									
		setErrCalc(0.01);																									
		setMapCalc("haldane"); //c("haldane","kosambi","c-f","morgan")														
		setLodCutoffM(3);																									//reqd																									
		setPhenoModel("np"); // "binary"); //"normal";//c("normal","binary","2part","np")														
		setAlMethod("em");//c("em","imp","hk","ehk","mr","mr-imp","mr-argmax")												//reqd
		setnPermutations(100);//100																							//reqd
		setNumCovar(1); 					//3  	
		setWinSize(10);				//10
		setGenoName("NULL");			//"Geno"
		setThreshLiJi(false);			//true
		setThresholdNumericalValue(0); //0 
		setMinDist(10);				//10
		setStepSize(5.0);				//5.0
		setAddModel(false);			//true
		setNumCofac(1);					//1
		setMlAlgo(true);				//true
		setSetupModel(true); //TRUE																						
		setIncludeEpistasis(false); //FALSE																				
		setUseDepPrior(false); //FALSE,																					
		setPriorMain(3);																										
		setPriorAll(priorMain + 3);																							
		setMaxQTLs ("NULL");																								
		setPriorProb(0.5);		
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("QTL Analysis Model \n");
		sb.append("resultFolderPath: "+resultFolderPath);
		sb.append("\n outFileName: "+outFileName);
		return sb.toString();
	}

	public String getResultFolderPath() {
		return resultFolderPath;
	}

	public void setResultFolderPath(String resultFolderPath) {
		this.resultFolderPath = resultFolderPath;
	}

	public String getOutFileName() {
		return outFileName;
	}

	public void setOutFileName(String outFileName) {
		this.outFileName = outFileName;
	}
	public String getDataCheckOutFileName() {
		return dataCheckOutFileName;
	}

	public void setDataCheckOutFileName(String dataCheckOutFileName) {
		this.dataCheckOutFileName = dataCheckOutFileName;
	}

	public String getDataFormat() {
		return dataFormat;
	}

	public void setDataFormat(String dataFormat) {
		this.dataFormat = dataFormat;
	}

	public String getFormat1() {
		return format1;
	}

	public void setFormat1(String format1) {
		this.format1 = format1;
	}

	public String getCrossType() {
		return crossType;
	}

	public void setCrossType(String crossType) {
		this.crossType = crossType;
	}

	public String getFile1() {
		return file1;
	}

	public void setFile1(String file1) {
		this.file1 = file1;
	}

	public String getFormat2() {
		return format2;
	}

	public void setFormat2(String format2) {
		this.format2 = format2;
	}

	public String getFile2() {
		return file2;
	}

	public void setFile2(String file2) {
		this.file2 = file2;
	}

	public String getFormat3() {
		return format3;
	}

	public void setFormat3(String format3) {
		this.format3 = format3;
	}

	public String getFile3() {
		return file3;
	}

	public void setFile3(String file3) {
		this.file3 = file3;
	}

	public String getP_geno() {
		return P_geno;
	}

	public void setP_geno(String p_geno) {
		P_geno = p_geno;
	}

	public int getBcNum() {
		return bcNum;
	}

	public void setBcNum(int bcNum) {
		this.bcNum = bcNum;
	}

	public int getfNum() {
		return fNum;
	}

	public void setfNum(int fNum) {
		this.fNum = fNum;
	}

	public boolean isDoMissing() {
		return doMissing;
	}

	public void setDoMissing(boolean doMissing) {
		this.doMissing = doMissing;
	}

	public boolean isDeleteMiss() {
		return deleteMiss;
	}

	public void setDeleteMiss(boolean deleteMiss) {
		this.deleteMiss = deleteMiss;
	}

	public double getCutOff() {
		return cutOff;
	}

	public void setCutOff(double cutOff) {
		this.cutOff = cutOff;
	}

	public boolean isDoDistortionTest() {
		return doDistortionTest;
	}

	public void setDoDistortionTest(boolean doDistortionTest) {
		this.doDistortionTest = doDistortionTest;
	}

	public double getPvalCutOff() {
		return pvalCutOff;
	}

	public void setPvalCutOff(double pvalCutOff) {
		this.pvalCutOff = pvalCutOff;
	}

	public boolean isDoCompareGeno() {
		return doCompareGeno;
	}

	public void setDoCompareGeno(boolean doCompareGeno) {
		this.doCompareGeno = doCompareGeno;
	}

	public double getCutoffP() {
		return cutoffP;
	}

	public void setCutoffP(double cutoffP) {
		this.cutoffP = cutoffP;
	}

	public boolean isDoCheckMarkerOrder() {
		return doCheckMarkerOrder;
	}

	public void setDoCheckMarkerOrder(boolean doCheckMarkerOrder) {
		this.doCheckMarkerOrder = doCheckMarkerOrder;
	}

	public double getLodThreshold() {
		return lodThreshold;
	}

	public void setLodThreshold(double lodThreshold) {
		this.lodThreshold = lodThreshold;
	}

	public boolean isDoCheckGenoErrors() {
		return doCheckGenoErrors;
	}

	public void setDoCheckGenoErrors(boolean doCheckGenoErrors) {
		this.doCheckGenoErrors = doCheckGenoErrors;
	}

	public double getLodCutOff() {
		return lodCutOff;
	}

	public void setLodCutOff(double lodCutOff) {
		this.lodCutOff = lodCutOff;
	}

	public double getErrorProb() {
		return errorProb;
	}

	public void setErrorProb(double errorProb) {
		this.errorProb = errorProb;
	}

	public String getTraitType() {
		return traitType;
	}

	public void setTraitType(String traitType) {
		this.traitType = traitType;
	}

	public String[] getyVars() {
		return yVars;
	}

	public void setyVars(String[] yVars) {
		this.yVars = yVars;
	}

	public String getmMethod() {
		return mMethod;
	}

	public void setmMethod(String mMethod) {
		this.mMethod = mMethod;
	}

	public double getStepCalc() {
		return stepCalc;
	}

	public void setStepCalc(double stepCalc) {
		this.stepCalc = stepCalc;
	}

	public double getErrCalc() {
		return errCalc;
	}

	public void setErrCalc(double errCalc) {
		this.errCalc = errCalc;
	}

	public String getMapCalc() {
		return mapCalc;
	}

	public void setMapCalc(String mapCalc) {
		this.mapCalc = mapCalc;
	}

	public double getLodCutoffM() {
		return lodCutoffM;
	}

	public void setLodCutoffM(double lodCutoffM) {
		this.lodCutoffM = lodCutoffM;
	}

	public String getPhenoModel() {
		return phenoModel;
	}

	public void setPhenoModel(String phenoModel) {
		this.phenoModel = phenoModel;
	}

	public String getAlMethod() {
		return alMethod;
	}

	public void setAlMethod(String alMethod) {
		this.alMethod = alMethod;
	}

	public int getnPermutations() {
		return nPermutations;
	}

	public void setnPermutations(int nPermutations) {
		this.nPermutations = nPermutations;
	}

	public int getNumCovar() {
		return numCovar;
	}

	public void setNumCovar(int numCovar) {
		this.numCovar = numCovar;
	}

	public double getWinSize() {
		return winSize;
	}

	public void setWinSize(double winSize) {
		this.winSize = winSize;
	}

	public String getGenoName() {
		return genoName;
	}

	public void setGenoName(String genoName) {
		this.genoName = genoName;
	}

	public boolean isThreshLiJi() {
		return threshLiJi;
	}

	public void setThreshLiJi(boolean threshLiJi) {
		this.threshLiJi = threshLiJi;
	}

	public double getThresholdNumericalValue() {
		return thresholdNumericalValue;
	}

	public void setThresholdNumericalValue(double thresholdNumericalValue) {
		this.thresholdNumericalValue = thresholdNumericalValue;
	}

	public double getMinDist() {
		return minDist;
	}

	public void setMinDist(double minDist) {
		this.minDist = minDist;
	}

	public double getStepSize() {
		return stepSize;
	}

	public void setStepSize(double stepSize) {
		this.stepSize = stepSize;
	}

	public boolean isAddModel() {
		return addModel;
	}

	public void setAddModel(boolean addModel) {
		this.addModel = addModel;
	}

	public int getNumCofac() {
		return numCofac;
	}

	public void setNumCofac(int numCofac) {
		this.numCofac = numCofac;
	}

	public boolean isMlAlgo() {
		return mlAlgo;
	}

	public void setMlAlgo(boolean mlAlgo) {
		this.mlAlgo = mlAlgo;
	}

	public boolean isSetupModel() {
		return setupModel;
	}

	public void setSetupModel(boolean setupModel) {
		this.setupModel = setupModel;
	}

	public boolean isIncludeEpistasis() {
		return includeEpistasis;
	}

	public void setIncludeEpistasis(boolean includeEpistasis) {
		this.includeEpistasis = includeEpistasis;
	}

	public boolean isUseDepPrior() {
		return useDepPrior;
	}

	public void setUseDepPrior(boolean useDepPrior) {
		this.useDepPrior = useDepPrior;
	}

	public int getPriorMain() {
		return priorMain;
	}

	public void setPriorMain(int priorMain) {
		this.priorMain = priorMain;
	}

	public int getPriorAll() {
		return priorAll;
	}

	public void setPriorAll(int priorAll) {
		this.priorAll = priorAll;
	}

	public String getMaxQTLs() {
		return maxQTLs;
	}

	public void setMaxQTLs(String maxQTLs) {
		this.maxQTLs = maxQTLs;
	}

	public double getPriorProb() {
		return priorProb;
	}

	public void setPriorProb(double priorProb) {
		this.priorProb = priorProb;
	}

}
