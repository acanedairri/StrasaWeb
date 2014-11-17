import org.analysis.rserve.manager.RServeManager;
import org.irri.breedingtool.rjava.manager.RJavaManager;

public class TestDesignLatinizedAlpha {

	private static String BSLASH = "\\";
	private static String FSLASH = "/";
	private static String PATH1 = System.getProperty("user.dir")+ System.getProperty("file.separator") + "SampleData" + System.getProperty("file.separator");
	public static String DATA_PATH = System.getProperty("user.dir")+ System.getProperty("file.separator") + "SampleData" + System.getProperty("file.separator");
	
	public static void main(String[] args) {
		
		//supply path where the output will be saved
		String path = DATA_PATH; 
		//supply the fieldbook name specified by the user
		String fieldBookName = "fieldbookPBToolsLatinizedAlphaLattice2"; 
		
		//specify parameters
		// sample test for case 1: number of fieldrows is divisible by the number of blocks per replicate
//		Integer numTrmt = 15;
//		Integer blkSize = 5;
//		Integer rep = 3;
//		Integer trial = 1;
//		Integer numFieldRow = 15;
//		String fieldOrder = "Serpentine";
		
		// sample test for case 1: number of fieldrows is divisible by the number of blocks per replicate
		Integer numTrmt = 15;
		Integer blkSize = 5;
		Integer rep = 3;
		Integer trial = 1;
		Integer numFieldRow = 3;
		String fieldOrder = "Serpentine";
		
		RServeManager rServeManager = new RServeManager();
		rServeManager.doDesignLatinizedAlpha(path, fieldBookName, numTrmt, blkSize, rep, trial, numFieldRow, fieldOrder);
//		RJavaManager rJavaManager= new RJavaManager();
//		rJavaManager.initPBtool();
//		rJavaManager.getPbToolRandomizationManager().doDesignLatinizedAlpha(path, fieldBookName, numTrmt, blkSize, 
//				rep, trial, numFieldRow, fieldOrder);
		
//		StringBuilder s = rJavaManager.getSTARDesignManager().getRscriptCommand();
//		System.out.println("Script Command:\n" +s.toString());
	}

}
