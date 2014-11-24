

import org.analysis.rserve.manager.RServeManager;

public class TestDesignAugmented {

	private static String BSLASH = "\\";
	private static String FSLASH = "/";
	private static String PATH1 = System.getProperty("user.dir")+ System.getProperty("file.separator") + "SampleData" + System.getProperty("file.separator");
	public static String DATA_PATH = PATH1.replace(BSLASH, FSLASH);

	public static void main(String[] args) {

		//supply path and name of active data
		String dataFileName = DATA_PATH + "fieldbookDesignAugmented.csv"; 
		//supply path and name of text file where text output is going to be saved
		String outFileName = DATA_PATH + "fieldbookDesignAugmented.txt"; 
		//supply path and name of graph file

		//specify parameters
		Integer repTrmt = 6;
		Integer unrepTrmt = 60;
		Integer rep = 5;
		Integer trial = 2;
		String design = "rcbd";

		RServeManager rServeManager= new RServeManager();
		rServeManager.doDesignAugmented(dataFileName, outFileName, repTrmt, unrepTrmt, rep, trial, design);
		//		RJavaManager rJavaManager= new RJavaManager();
		//		rJavaManager.initPBtool();
	}

}
