

import org.analysis.rserve.manager.RServeManager;
import org.irri.breedingtool.rjava.manager.RJavaManager;

public class TestDesignCRD {

	private static String BSLASH = "\\";
	private static String FSLASH = "/";
	private static String PATH1 = System.getProperty("user.dir")+ System.getProperty("file.separator") + "SampleData" + System.getProperty("file.separator");
	public static String DATA_PATH = System.getProperty("user.dir")+ System.getProperty("file.separator") + "SampleData" + System.getProperty("file.separator");
	
	public static void main(String[] args) {
		
		//supply path where the output will be saved
		String path = DATA_PATH; 
		//supply the fieldbook name specified by the user
		String fieldBookName = "fieldbookDesignCRD"; 
		
		//specify parameters
		String[] factorName = {"VARIETY", "NITROGEN"};
		String[] factorID = {"V", "N"};
		Integer[] factorLevel = {4, 2};
		Integer rep = 2;
		Integer trial = 2;
		String fieldOrder = "Serpentine";
		Integer numFieldRow = 2;
		
		RServeManager rServeManager = new RServeManager();
		rServeManager.doDesignCRD(path.replace(BSLASH, FSLASH), fieldBookName, factorName, factorID, factorLevel, rep, trial, numFieldRow, fieldOrder);
//		RJavaManager rJavaManager= new RJavaManager();
//		rJavaManager.initPBtool();
//		rJavaManager.getPbToolRandomizationManager().doDesignCRD(path, fieldBookName, factorName, factorID, factorLevel, rep, trial, numFieldRow, fieldOrder);
	}

}
