import org.analysis.rserve.manager.RServeManager;

public class TestDesignAugmentedAlpha {

	private static String BSLASH = "\\";
	private static String FSLASH = "/";
	private static String PATH1 = System.getProperty("user.dir")+ System.getProperty("file.separator") + "SampleData" + System.getProperty("file.separator");
	public static String DATA_PATH = System.getProperty("user.dir")+ System.getProperty("file.separator") + "SampleData" + System.getProperty("file.separator");
	
	public static void main(String[] args) {
		
		//supply path where the output will be saved
		String path = DATA_PATH; 
		//supply the fieldbook name specified by the user
		String fieldBookName = "fieldbookAugmentedAlphaLattice"; 
		
		//specify parameters
		Integer numCheck = 9;
		Integer numNew = 63;
		String trmtName = "EntryNum";
		Integer blkSize = 10;
		Integer rep = 3;
		Integer trial = 2;
		Integer rowPerBlk = 5;
		Integer rowPerRep = 15;
		Integer numFieldRow = 15;
		String fieldOrder = "Serpentine";
		String trmtLabel = "Designation";
		String checkTrmt = null;
		String newTrmt = null;
		
		RServeManager rServeManager = new RServeManager();
		rServeManager.doDesignAugmentedAlpha(path, fieldBookName, numCheck, numNew, trmtName, blkSize, rep, trial, rowPerBlk, rowPerRep, numFieldRow, fieldOrder, trmtLabel, checkTrmt, newTrmt);
		
//		RJavaManager rJavaManager= new RJavaManager();
//		rJavaManager.initPBtool();
//		rJavaManager.getPbToolRandomizationManager().doDesignAugmentedAlpha(path, fieldBookName, numCheck, numNew, trmtName, 
//				blkSize, rep, trial, rowPerBlk, rowPerRep, numFieldRow, fieldOrder, trmtLabel, checkTrmt, newTrmt);
		
	}

}
