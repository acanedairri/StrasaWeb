

import org.analysis.rserve.manager.RServeManager;
import org.irri.breedingtool.rjava.manager.RJavaManager;

public class TestDesignAugmentedLSD {

	private static String BSLASH = "\\";
	private static String FSLASH = "/";
	private static String PATH1 = System.getProperty("user.dir")+ System.getProperty("file.separator") + "SampleData" + System.getProperty("file.separator");
	public static String DATA_PATH = PATH1.replace(BSLASH, FSLASH);
	
	public static void main(String[] args) {
		
		//supply path where the output will be saved
		String path = DATA_PATH; 
		//supply the fieldbook name specified by the user
		String fieldBookName = "fieldbookDesignAugmentedLSD"; 
		
		//specify parameters
		Integer repTrmt = 5;
		Integer unrepTrmt = 230;
		Integer fieldRow = 17;
		Integer trial = 2;
		String fieldOrder = "Serpentine";
		
		RServeManager rServeManager = new RServeManager();
		rServeManager.doDesignAugmentedLSD(path, fieldBookName, repTrmt, unrepTrmt, fieldRow, trial, fieldOrder);
		
//		RJavaManager rJavaManager= new RJavaManager();
//		rJavaManager.initStar();
//		rJavaManager.getSTARDesignManager().doDesignAugLSD(path, fieldBookName, repTrmt, unrepTrmt, fieldRow, 
//				trial, fieldOrder);
//		
//		StringBuilder s = rJavaManager.getSTARDesignManager().getRscriptCommand();
//		System.out.println("Script Command:\n" +s.toString());
	}

}
