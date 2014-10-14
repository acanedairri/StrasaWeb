

import org.analysis.rserve.manager.RServeManager;
import org.irri.breedingtool.rjava.manager.RJavaManager;
import org.strasa.web.analysis.view.model.SingleSiteAnalysisModel;

public class TestSingleEnvironmentPRep {

	private static String BSLASH = "\\";
	private static String FSLASH = "/";
	private static String PATH1 = System.getProperty("user.dir")+ System.getProperty("file.separator") + "SampleData" + System.getProperty("file.separator");
	public static String DATA_PATH = System.getProperty("user.dir")+ System.getProperty("file.separator") + "SampleData" + System.getProperty("file.separator");
	
	public static void main(String[] args) {
		
		SingleSiteAnalysisModel ssaModel = new SingleSiteAnalysisModel();
		String resultFolderPath = DATA_PATH;
		
		//Declare Test Variables
		String dataFileName = DATA_PATH + "2013WSPYT_rawdata_prep.csv";
		String[] respvars = {"Plotyield.Adj"}; 
		String genotype = "ENTRY";
		String row = "ROW";
		String column = "COLUMN";
		String environment = null;
		boolean genotypeFixed = true;
		boolean genotypeRandom = true; 
		boolean excludeControls = false;
		String[] controlLevels = null; // c("CIHERANG","CIHERANGSUB1","IRRI105","IRRI119", "IRRI154","IRRI168") 
		boolean moransTest = false; // for BIMS always false
		String[] spatialStruc = {"none", "CompSymm", "Gaus", "Exp", "Spher"}; // {"none", "CompSymm", "Gaus", "Exp", "Spher"}, for BIMS include the five choices, for standalone determine by the user
		boolean descriptiveStat = true;
		boolean varianceComponents = true; 
		boolean boxplotRawData = true;
		boolean histogramRawData = true;
		boolean heatmapResiduals = true; 
		boolean diagnosticPlot = true;
		
		//Initialize Model
		ssaModel.setResultFolderPath(resultFolderPath.replace(BSLASH, FSLASH));
		ssaModel.setDataFileName(dataFileName.replace(BSLASH, FSLASH));
		ssaModel.setRespvars(respvars);
		ssaModel.setGenotype(genotype);
		ssaModel.setRow(row);
		ssaModel.setColumn(column);
		ssaModel.setEnvironment(environment);
		ssaModel.setGenotypeFixed(genotypeFixed);
		ssaModel.setGenotypeRandom(genotypeRandom);
		ssaModel.setExcludeControls(excludeControls);
		ssaModel.setControlLevels(controlLevels);
		ssaModel.setMoransTest(moransTest);
		ssaModel.setSpatialStruc(spatialStruc);
		ssaModel.setDescriptiveStat(descriptiveStat);
		ssaModel.setVarianceComponents(varianceComponents);
		ssaModel.setBoxplotRawData(boxplotRawData);
		ssaModel.setHistogramRawData(histogramRawData);
		ssaModel.setHeatmapResiduals(heatmapResiduals);
		ssaModel.setDiagnosticPlot(diagnosticPlot);
		
		//call Rfunction
		RServeManager rServeManager= new RServeManager();
		rServeManager.doSingleEnvironmentAnalysisPRep(ssaModel);
		
	}

}