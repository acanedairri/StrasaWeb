
import org.analysis.rserve.manager.RServeManager;

public class TestOutlierDetection {

	private static String BSLASH = "\\";
	private static String FSLASH = "/";
	private static String PATH1 = System.getProperty("user.dir")+ System.getProperty("file.separator") + "SampleData" + System.getProperty("file.separator");
	public static String DATA_PATH = System.getProperty("user.dir")+ System.getProperty("file.separator") + "SampleData" + System.getProperty("file.separator");
	
	public static void main(String[] args) {
		RServeManager rServeMgr = new RServeManager();
		//supply path and name of text file where text output is going to be saved
		String outputPath = DATA_PATH; 
		
		//supply path and name of active data
		String dataFileName = DATA_PATH + "2013DSRYT_rowcol.csv"; 
		//specify parameters
		String respvar = "GRNYLD.Y.ha.";
		String trmt = "ENTRY.";
		String rep = "REP.";
		
		rServeMgr.doOutlierDetection(dataFileName.replace(BSLASH, FSLASH), outputPath.replace(BSLASH, FSLASH), respvar, trmt, rep);
	}
}
