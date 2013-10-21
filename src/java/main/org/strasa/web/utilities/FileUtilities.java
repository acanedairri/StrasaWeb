package org.strasa.web.utilities;

import java.io.InputStream;
import java.io.OutputStream;

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

}
