package com.usa.state.gov.his.util;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncrypt {
	
	private static String secretKey = "shaikabdulubed78";
	private static String salt = "encryptionValues";
	
	//password encryption
	public String doEncrypt(String stringToEncrypt) throws Exception {
		IvParameterSpec iv = new IvParameterSpec(salt.getBytes());
		SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "AES");
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec , iv);
		cipher.doFinal(stringToEncrypt.getBytes());
		byte[] encrypted = cipher.doFinal(stringToEncrypt.getBytes());
		return java.util.Base64.getEncoder().encodeToString(encrypted);
	}
	

	
	
	public String doDecrypt(String strToDecrypt) throws Exception {
		IvParameterSpec iv = new IvParameterSpec(salt.getBytes());
		SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "AES");
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, secretKeySpec , iv);
		byte[] original = cipher.doFinal(java.util.Base64.getDecoder().decode(strToDecrypt));
		return new String(original);
	}


}
