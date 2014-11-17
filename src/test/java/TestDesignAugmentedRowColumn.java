import org.analysis.rserve.manager.RServeManager;
import org.irri.breedingtool.rjava.manager.RJavaManager;

public class TestDesignAugmentedRowColumn {

	private static String BSLASH = "\\";
	private static String FSLASH = "/";
	private static String PATH1 = System.getProperty("user.dir")+ System.getProperty("file.separator") + "SampleData" + System.getProperty("file.separator");
	public static String DATA_PATH = System.getProperty("user.dir")+ System.getProperty("file.separator") + "SampleData" + System.getProperty("file.separator");
	
	public static void main(String[] args) {
		
		//supply path where the output will be saved
		String path = DATA_PATH; 
		//supply the fieldbook name specified by the user
		String fieldBookName = "fieldbookAugmentedRowColumn"; 
		
		//specify parameters
		Integer numCheck = 12;
		Integer numNew = 120;
		String trmtName = "ENTRYNO";
		Integer rep = 2; 
		Integer trial = 2; 
		Integer rowblkPerRep = 3;
		Integer rowPerRowblk = 3; 
		Integer numFieldRow = 18;
		String fieldOrder = "Serpentine";
		String trmtLabel = null;
		String checkTrmt = null;
		String newTrmt = null;
		
		RServeManager rServeManager = new RServeManager();
		rServeManager.doDesignAugmentedRowColumn(path, fieldBookName, numCheck, numNew, trmtName, rep, trial, rowblkPerRep, rowPerRowblk, numFieldRow, fieldOrder, trmtLabel, checkTrmt, newTrmt);
//		RJavaManager rJavaManager= new RJavaManager();
//		rJavaManager.initPBtool();
//		rJavaManager.getPbToolRandomizationManager().doDesignAugmentedRowColumn(path, fieldBookName, numCheck, numNew,
//				trmtName, rep, trial, rowblkPerRep, rowPerRowblk, numFieldRow, fieldOrder, trmtLabel, checkTrmt, 
//				newTrmt);
		
	}

}
