

import org.analysis.rserve.manager.RServeManager;

public class TestDesignLSD {

	private static String BSLASH = "\\";
	private static String FSLASH = "/";
	private static String PATH1 = System.getProperty("user.dir")+ System.getProperty("file.separator") + "SampleData" + System.getProperty("file.separator");
	public static String DATA_PATH = System.getProperty("user.dir")+ System.getProperty("file.separator") + "SampleData" + System.getProperty("file.separator");
	
	public static void main(String[] args) {
		
		//supply path where the output will be saved
		String path = DATA_PATH; 
		//supply the fieldbook name specified by the user
		String fieldBookName = "fieldbookDesignLSD"; 
		
		//specify parameters
		String[] factorName = {"VARIETY", "NITROGEN"};
		String[] factorID = {"V", "N"};
		Integer[] factorLevel = {5,3};
		Integer trial = 2;
		String fieldOrder = "Serpentine";
		
		RServeManager rServeManager = new RServeManager();
		rServeManager.doDesignLSD(path.replace(BSLASH, FSLASH), fieldBookName, factorName, factorID, factorLevel, trial, fieldOrder);
//		
//		RJavaManager rJavaManager= new RJavaManager();
//		rJavaManager.initPBtool();
//		rJavaManager.getPbToolRandomizationManager().doDesignLSD(path, fieldBookName, factorName, factorID, factorLevel, 
//				trial, fieldOrder);
	}

}
