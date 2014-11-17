import org.irri.breedingtool.rjava.manager.RJavaManager;

public class TestDesignAlpha {

	private static String BSLASH = "\\";
	private static String FSLASH = "/";
	private static String PATH1 = System.getProperty("user.dir")+ System.getProperty("file.separator") + "SampleData" + System.getProperty("file.separator");
	public static String DATA_PATH = System.getProperty("user.dir")+ System.getProperty("file.separator") + "SampleData" + System.getProperty("file.separator");
	
	public static void main(String[] args) {
		//supply path where the output will be saved
		String path = DATA_PATH; 
		//supply the fieldbook name specified by the user
		String fieldBookName = "fieldbookPBToolsAlphaLattice"; 
				
		//specify parameters
		Integer numTrmt = 70;
		Integer blkSize = 14;
		Integer rep = 2;
		Integer trial = 3;
		Integer rowPerBlk = 14;
		Integer rowPerRep = 14;
		Integer numFieldRow = 28;
		String fieldOrder = "Serpentine";
				
		RJavaManager rJavaManager= new RJavaManager();
		rJavaManager.initPBtool();
		rJavaManager.getPbToolRandomizationManager().doDesignAlpha(path, fieldBookName, numTrmt, blkSize, 
				rep, trial, rowPerBlk, rowPerRep, numFieldRow, fieldOrder);
	}

}
