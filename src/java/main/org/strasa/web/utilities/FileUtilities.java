package org.strasa.web.utilities;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.zkoss.zul.Filedownload;

public class FileUtilities {

	public static void uploadFile(String filepath,
            InputStream file) {
    try {
        OutputStream out = new java.io.FileOutputStream(filepath);
        InputStream in = file;
        int read = 0;
        byte[] bytes = new byte[1024];
        while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            in.close();
            out.flush();
            out.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
	
	public static void exportData(List<String> columns, List<String[]> rows, String outputFileName){
		List<String[]> grid = rows;
		
		StringBuffer sb = new StringBuffer();

		System.out.println("creating File...");
			int ctr=0;
			for (String s : columns) {
				ctr++;
				sb.append(s);
				if(ctr!=columns.size()) sb.append(",");
			}
			sb.append("\n");
	
		for (String[] row : grid) {
			ctr=0;
			for (String s : row) {
				ctr++;
				sb.append(s);
				if(ctr!=row.length) sb.append(",");
			}
			sb.append("\n");
		}
		
		System.out.println("downloading File...");
		   Filedownload.save(sb.toString().getBytes(), "text/plain", outputFileName);
	}

}
