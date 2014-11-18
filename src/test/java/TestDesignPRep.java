import org.analysis.rserve.manager.RServeManager;
import org.irri.breedingtool.rjava.manager.RJavaManager;

public class TestDesignPRep {

	private static String BSLASH = "\\";
	private static String FSLASH = "/";
	private static String PATH1 = System.getProperty("user.dir")+ System.getProperty("file.separator") + "SampleData" + System.getProperty("file.separator");
	public static String DATA_PATH = System.getProperty("user.dir")+ System.getProperty("file.separator") + "SampleData" + System.getProperty("file.separator");
	
	public static void main(String[] args) {
		
		//supply path where the output will be saved
		String path = DATA_PATH; 
		//supply the fieldbook name specified by the user
		String fieldBookName = "fieldbookDesignPRep"; 
		
		//specify parameters
		String[] trmtGrpName = {"NewRepTrmt", "NewUnrepTrmt", "Parent"};
		Integer[] numTrmtPerGrp = {48, 80, 2};
		Integer[] trmtRepPerGrp = {2, 1, 2};
		String trmtName = "ENTRYNO";
		Integer blk = 6;
		Integer trial = 1;
		Integer rowPerBlk = 6;
		Integer numFieldRow = 18; 
		String fieldOrder = "Serpentine";
		String trmtLabel = null;
		String trmtListPerGrp = null;
		
		RServeManager rServeManager = new RServeManager();
		rServeManager.doDesignPRep(path.replace(BSLASH, FSLASH), fieldBookName, trmtGrpName, numTrmtPerGrp, trmtRepPerGrp, trmtName, blk, trial, rowPerBlk, numFieldRow, fieldOrder, trmtLabel, trmtListPerGrp);
//		RJavaManager rJavaManager= new RJavaManager();
//		rJavaManager.initPBtool();
//		rJavaManager.getPbToolRandomizationManager().doDesignPRep(path, fieldBookName, trmtGrpName, numTrmtPerGrp, 
//				trmtRepPerGrp, trmtName, blk, trial, rowPerBlk, numFieldRow, fieldOrder, trmtLabel, trmtListPerGrp);
	}

}
