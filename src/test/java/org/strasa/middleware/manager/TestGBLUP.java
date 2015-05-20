package org.strasa.middleware.manager;
import org.analysis.rserve.manager.RServeManager;
import org.irri.breedingtool.rjava.manager.RJavaManager;
import org.strasa.web.analysis.view.model.GenomicSelectionModel;

public class TestGBLUP {

	private static String BSLASH = "\\";
	private static String FSLASH = "/";
	private static String PATH1 = System.getProperty("user.dir")+ System.getProperty("file.separator") + "SampleData" + System.getProperty("file.separator");
	public static String DATA_PATH = System.getProperty("user.dir")+ System.getProperty("file.separator") + "SampleData" + System.getProperty("file.separator");

	public static void main(String[] args) {

		RServeManager rServeManager = new RServeManager();
		GenomicSelectionModel gblupModel = new GenomicSelectionModel();
		
		gblupModel.initTestVars("GBLUP");
		rServeManager.doGBLUP(gblupModel);

		//		//Pedigree-based
		//		String doPedigree = "TRUE";
		//		//supply format of input file, whether "csv", "ctxt", "stxt", "ttxt", or "sctxt" 
		//		String fileFormat = "csv";
		//		//supply path and name of input file
		//		String fileName = DATA_PATH + "pedFile.csv";
		//		//supply type of relationship matrix to create: "dom", "add", "sm-smin","realized","realizedAB","sm","additive"
		//		String relType = "dom";

		//		//Marker-based
		//		String doPedigree = "FALSE";		
		//		//supply format of input file, whether "csv", "ctxt", "stxt", "ttxt", or "sctxt" 
		//		String fileFormat = "csv";
		//		//supply path and name of input file
		//		String fileName = DATA_PATH + "ori_file_type3_ed.csv";
		//		//supply type of relationship matrix to create: "dom", "add", "sm-smin","realized","realizedAB","sm","additive"
		//		String relType = "realized"; //sm-smin";
		//		int markerFormat = 3;
		//		
		//		//supply path and name of text file where relationship matrix is going to be saved
		//		String outFileName = "NULL";
		//		if (doPedigree == "TRUE") outFileName = "pedigreeRelation_" + relType; //DATA_PATH + 
		//		else outFileName = "markerRelation_" + relType; //DATA_PATH + 

		//		RJavaManager rJavaManager= new RJavaManager();
		//		rJavaManager.initPBtool();
		//		rJavaManager.getWebToolManager().doGBLUP(
		//				resultFolderPath, doPedigree, fileFormat, fileName,
		//				relType, outFileName, markerFormat);

		//		rServeManager.doGBLUP(resultFolderPath, pheno_file, geno_file, markerFormat, importRel, rel_file, rMatType, map_file, traitNames, covariates, doCV, samplingStrat, popStruc_file, nfolds, nrep);
		//		rJavaManager.getWebToolManager().doGBLUP(
		//				resultFolderPath, pheno_file, geno_file, markerFormat, importRel, rel_file, rMatType, 
		//                map_file, traitNames, covariates, doCV, 
		////                varCompEst, 
		//                samplingStrat, popStruc_file, nfolds, nrep);

		//			doGBLUP <- function(outputPath, pheno_file, geno_file = NULL, markerFormat = c(1, 2, 3), , 
		//	                importRel = FALSE, rel_file = NULL, rMatType = c("t1", "t2", "t3", "t4"), 
		//	                map_file = NULL, # ped_file = NULL, #peFormat = NULL, #data quality check options, ...,
		//	                traitNames, covariates = NULL, doCV = FALSE, varCompEst = c("BL", "BRR"), samplingStrat = c("random","within popStruc"), nfolds = 2, nrep = 1) {

		System.out.println("TestGBLUP end");

	}

}