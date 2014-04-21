package org.strasa.web.analysis.view.model;

import org.zkoss.zk.ui.Sessions;

public class SingleSiteAnalysisModel {
	private static String BSLASH = "\\";
	private static String FSLASH = "/";
	private static String OUTPUTFOLDER_PATH =  Sessions.getCurrent().getWebApp().getRealPath("resultanalysis")+ System.getProperty("file.separator")+
			"user2"+ System.getProperty("file.separator")+"Single-Site"+ System.getProperty("file.separator")+"MyResult"+ System.getProperty("file.separator");
	public static String DATA_PATH = System.getProperty("user.dir")+ System.getProperty("file.separator") + "sample_datasets" + System.getProperty("file.separator");
	
	private String resultFolderPath;
	private String outFileName;
	private String dataFileName;

	private int design;
	private String[] respvars = {"Yield"};
	private String environment;
	private String[] environmentLevels = {};
	private String genotype;
	private String block;
	private String rep;
	private String row;
	private String column;
	private boolean descriptiveStat; 
	private boolean varianceComponents;
	private boolean boxplotRawData;
	private boolean histogramRawData;
	private boolean heatmapResiduals;
	private String heatmapRow;

	private String heatmapColumn;
	private boolean diagnosticPlot;
	private boolean genotypeFixed;
	private boolean performPairwise;
	private String pairwiseAlpha;
	private String[] genotypeLevels = {"GEN1", "GEN2", "GEN3", "GEN4", "GEN5", "GEN6", "GEN7", "GEN8", "GEN9", "GEN10", "GEN11", "GEN12", "GEN13", "GEN14", "GEN15"};
	private String[] controlLevels = {"GEN14"};
	private boolean compareControl;
	private boolean performAllPairwise;
	private boolean genotypeRandom;
	private boolean excludeControls;
	private boolean genoPhenoCorrelation;
	

	public SingleSiteAnalysisModel() {
		this.resultFolderPath = OUTPUTFOLDER_PATH.replace(BSLASH, FSLASH);
		this.outFileName = OUTPUTFOLDER_PATH.replace(BSLASH, FSLASH) + "SEA_output.txt";

		this.dataFileName = DATA_PATH.replace(BSLASH, FSLASH) + "RCB_ME.csv";

		this.design = 0;
		this.environment = "Env";
		this.genotype = "Genotype";
		this.block = "Block";
		this.rep = "NULL";
		this.row = "NULL";
		this.column = "NULL";
		this.descriptiveStat = true; 
		this.varianceComponents = true;
		this.boxplotRawData = true;
		this.histogramRawData = false;
		this.heatmapResiduals = false;
		this.heatmapRow = "NULL";
		this.heatmapColumn = "NULL";
		this.diagnosticPlot = true;
		this.genotypeFixed = true;
		this.performPairwise = true;
		this.pairwiseAlpha = "0.05";
		this.compareControl = true;
		this.performAllPairwise = false;
		this.genotypeRandom = false;
		this.excludeControls = false;
		this.genoPhenoCorrelation = false;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("SingleSiteAnalysisModel \n");
		sb.append("resultFolderPath: "+resultFolderPath);
		sb.append("\n outFileName: "+outFileName);
		sb.append("\n dataFileName: "+dataFileName);
		sb.append("\n environment: "+environment);
		sb.append("\n genotype: "+genotype);
		sb.append("\n block: "+block);
		sb.append("\n rep: "+design);
		sb.append("\n row: "+row);
		sb.append("\n column: "+column);
		sb.append("\n descriptiveStat: "+descriptiveStat);
		sb.append("\n varianceComponents: "+varianceComponents);
		sb.append("\n boxplotRawData: "+boxplotRawData);
		sb.append("\n histogramRawData: "+histogramRawData);
		sb.append("\n heatmapResiduals: "+heatmapResiduals);
		sb.append("\n heatmapRow: "+heatmapRow);
		sb.append("\n heatmapColumn: "+heatmapColumn);
		sb.append("\n diagnosticPlot: "+diagnosticPlot);
		sb.append("\n genotypeFixed: "+genotypeFixed);
		sb.append("\n performPairwise: "+performPairwise);
		sb.append("\n pairwiseAlpha: "+pairwiseAlpha);
		sb.append("\n compareControl: "+compareControl);
		sb.append("\n performAllPairwise: "+performAllPairwise);
		sb.append("\n genotypeRandom: "+genotypeRandom);
		sb.append("\n excludeControls: "+excludeControls);
		sb.append("\n genoPhenoCorrelation: "+genoPhenoCorrelation);

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

	public String getDataFileName() {
		return dataFileName;
	}

	public void setDataFileName(String dataFileName) {
		this.dataFileName = dataFileName;
	}

	public int getDesign() {
		return design;
	}

	public void setDesign(int design) {
		this.design = design;
	}

	public String[] getRespvars() {
		return respvars;
	}

	public void setRespvars(String[] respvars) {
		this.respvars = respvars;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public String[] getEnvironmentLevels() {
		return environmentLevels;
	}

	public void setEnvironmentLevels(String[] environmentLevels) {
		this.environmentLevels = environmentLevels;
	}

	public String getGenotype() {
		return genotype;
	}

	public void setGenotype(String genotype) {
		this.genotype = genotype;
	}

	public String getBlock() {
		return block;
	}

	public void setBlock(String block) {
		this.block = block;
	}

	public String getRep() {
		return rep;
	}

	public void setRep(String rep) {
		this.rep = rep;
	}

	public String getRow() {
		return row;
	}

	public void setRow(String row) {
		this.row = row;
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public boolean isDescriptiveStat() {
		return descriptiveStat;
	}

	public void setDescriptiveStat(boolean descriptiveStat) {
		this.descriptiveStat = descriptiveStat;
	}

	public boolean isVarianceComponents() {
		return varianceComponents;
	}

	public void setVarianceComponents(boolean varianceComponents) {
		this.varianceComponents = varianceComponents;
	}

	public boolean isBoxplotRawData() {
		return boxplotRawData;
	}

	public void setBoxplotRawData(boolean boxplotRawData) {
		this.boxplotRawData = boxplotRawData;
	}

	public boolean isHistogramRawData() {
		return histogramRawData;
	}

	public void setHistogramRawData(boolean histogramRawData) {
		this.histogramRawData = histogramRawData;
	}

	public boolean isHeatmapResiduals() {
		return heatmapResiduals;
	}

	public void setHeatmapResiduals(boolean heatmapResiduals) {
		this.heatmapResiduals = heatmapResiduals;
	}

	public String getHeatmapRow() {
		return heatmapRow;
	}

	public void setHeatmapRow(String heatmapRow) {
		this.heatmapRow = heatmapRow;
	}

	public String getHeatmapColumn() {
		return heatmapColumn;
	}

	public void setHeatmapColumn(String heatmapColumn) {
		this.heatmapColumn = heatmapColumn;
	}

	public boolean isDiagnosticPlot() {
		return diagnosticPlot;
	}

	public void setDiagnosticPlot(boolean diagnosticPlot) {
		this.diagnosticPlot = diagnosticPlot;
	}

	public boolean isGenotypeFixed() {
		return genotypeFixed;
	}

	public void setGenotypeFixed(boolean genotypeFixed) {
		this.genotypeFixed = genotypeFixed;
	}

	public boolean isPerformPairwise() {
		return performPairwise;
	}

	public void setPerformPairwise(boolean performPairwise) {
		this.performPairwise = performPairwise;
	}

	public String getPairwiseAlpha() {
		return pairwiseAlpha;
	}

	public void setPairwiseAlpha(String pairwiseAlpha) {
		this.pairwiseAlpha = pairwiseAlpha;
	}

	public String[] getGenotypeLevels() {
		return genotypeLevels;
	}

	public void setGenotypeLevels(String[] genotypeLevels) {
		this.genotypeLevels = genotypeLevels;
	}

	public String[] getControlLevels() {
		return controlLevels;
	}

	public void setControlLevels(String[] controlLevels) {
		this.controlLevels = controlLevels;
	}

	public boolean isCompareControl() {
		return compareControl;
	}

	public void setCompareControl(boolean compareControl) {
		this.compareControl = compareControl;
	}

	public boolean isPerformAllPairwise() {
		return performAllPairwise;
	}

	public void setPerformAllPairwise(boolean performAllPairwise) {
		this.performAllPairwise = performAllPairwise;
	}

	public boolean isGenotypeRandom() {
		return genotypeRandom;
	}

	public void setGenotypeRandom(boolean genotypeRandom) {
		this.genotypeRandom = genotypeRandom;
	}

	public boolean isExcludeControls() {
		return excludeControls;
	}

	public void setExcludeControls(boolean excludeControls) {
		this.excludeControls = excludeControls;
	}

	public boolean isGenoPhenoCorrelation() {
		return genoPhenoCorrelation;
	}

	public void setGenoPhenoCorrelation(boolean genoPhenoCorrelation) {
		this.genoPhenoCorrelation = genoPhenoCorrelation;
	}

}
