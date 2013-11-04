package org.strasa.web.common.api;

public class Encryptions {

	
	public static String encryptStringToNumber(String strInput, long l) {
        StringBuffer strEncryptedData = new StringBuffer();
        for(int numCnt = 0; numCnt < strInput.length(); numCnt++) {
             int numVal = Character.getNumericValue(strInput.charAt(numCnt));
             
             strEncryptedData.append(numVal - 9 + l);
        }
        return strEncryptedData.toString();
   }

	public static String encryptStringToNumber(String name, long time,
			String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
