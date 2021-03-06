import org.analysis.rserve.manager.RServeManager;




public class TestDesignLattice {

	private static String BSLASH = "\\";
	private static String FSLASH = "/";
	private static String PATH1 = System.getProperty("user.dir")+ System.getProperty("file.separator") + "SampleData" + System.getProperty("file.separator");
	public static String DATA_PATH = PATH1.replace(BSLASH, FSLASH);
	
	public static void main(String[] args) {
		
		//supply path where the output will be saved
		String path = DATA_PATH; 
		//supply the fieldbook name specified by the user
		String fieldBookName = "fieldbookDeisgnLattice"; 
		
		//specify parameters
		Integer numTrmt = 9;
		Integer rep = 2;
		Integer trial = 2;
		Integer numFieldRow = 3;
		String fieldOrder = "Serpentine";
		
		RServeManager rServeManager = new RServeManager();
		rServeManager.doDesignLattice(path, fieldBookName, numTrmt, rep, trial, numFieldRow, fieldOrder);
//		RJavaManager rJavaManager= new RJavaManager();
//		rJavaManager.initStar();
//		rJavaManager.getSTARDesignManager().doDesignLattice(path, fieldBookName,  
//				numTrmt, rep, trial, numFieldRow, fieldOrder);
//		
//		StringBuilder s = rJavaManager.getSTARDesignManager().getRscriptCommand();
//		System.out.println("Script Command:\n" +s.toString());

	}

}
