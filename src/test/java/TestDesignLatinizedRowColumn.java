import org.analysis.rserve.manager.RServeManager;
import org.irri.breedingtool.rjava.manager.RJavaManager;

public class TestDesignLatinizedRowColumn {

	private static String BSLASH = "\\";
	private static String FSLASH = "/";
	private static String PATH1 = System.getProperty("user.dir")+ System.getProperty("file.separator") + "SampleData" + System.getProperty("file.separator");
	public static String DATA_PATH = System.getProperty("user.dir")+ System.getProperty("file.separator") + "SampleData" + System.getProperty("file.separator");
	
	public static void main(String[] args) {
		
		//supply path where the output will be saved
		String path = DATA_PATH; 
		//supply the fieldbook name specified by the user
		String fieldBookName = "fieldbookLatinizedRowColumn"; 
		
		//specify parameters
		Integer numTrmt = 9;
		Integer rep = 3;
		Integer rowPerRep = 3;
		Integer numFieldRow = 9;
		Integer trial = 1;
		String fieldOrder = "Serpentine";
		
		RServeManager rServeManager = new RServeManager();
		rServeManager.doDesignLatinizedRowColumn(path, fieldBookName, numTrmt, rep, trial, rowPerRep, numFieldRow, fieldOrder);
//		RJavaManager rJavaManager= new RJavaManager();
//		rJavaManager.initPBtool();
//		rJavaManager.getPbToolRandomizationManager().doDesignLatinizedRowColumn(path, fieldBookName, numTrmt, 
//				rep, trial, rowPerRep, numFieldRow, fieldOrder);
		
//		StringBuilder s = rJavaManager.getSTARDesignManager().getRscriptCommand();
//		System.out.println("Script Command:\n" +s.toString());
	}

}
