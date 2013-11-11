package org.strasa.web.common.api;

import org.jasypt.util.password.ConfigurablePasswordEncryptor;

public class Encryptions {

	
	public static String encryptStringToNumber(String strInput, long l) {
		ConfigurablePasswordEncryptor passwordEncryptor = new ConfigurablePasswordEncryptor();
		passwordEncryptor.setAlgorithm("SHA-1");
		passwordEncryptor.setPlainDigest(true);
		String encryptedPassword = passwordEncryptor.encryptPassword(strInput);
		System.out.println("Sample: " + passwordEncryptor.encryptPassword("SAMPLE"));

		System.out.println("Sample: " + passwordEncryptor.encryptPassword("SAMPLE"));
		return  encryptedPassword;
   }

	public static String encryptStringToNumber(String name, long time,
			String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
