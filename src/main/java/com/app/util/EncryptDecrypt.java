package com.app.util;

public class EncryptDecrypt {
	
	public static String encrypt(String value) {
		String encryptedString = "";
		for(int i= 0; i< value.length(); i++) {
			if((value.charAt(i) >= 65 || value.charAt(i) <= 90) ||(value.charAt(i) >= 65 || value.charAt(i) <= 122)) {
				encryptedString += (char) (value.charAt(i) + 2);
			}
			else if((value.charAt(i) >= 49 || value.charAt(i) <= 57)) {
				encryptedString += (char) (value.charAt(i) + 3);
			}
			else {
				encryptedString += (char) (value.charAt(i) + 1);
			}
		}
		return encryptedString;
	}
	
	public static String decrypt(String value) {
		String decryptedString= "";
		for(int i= 0; i< value.length(); i++) {
			if((value.charAt(i) >= 65 || value.charAt(i) <= 90) ||(value.charAt(i) >= 65 || value.charAt(i) <= 122)) {
				decryptedString += (char) (value.charAt(i) - 2);
			}
			else if((value.charAt(i) >= 49 || value.charAt(i) <= 57)) {
				decryptedString += (char) (value.charAt(i) + 3);
			}
			else {
				decryptedString += (char) (value.charAt(i) - 1);
			}
		}
		return decryptedString;
	}

}
