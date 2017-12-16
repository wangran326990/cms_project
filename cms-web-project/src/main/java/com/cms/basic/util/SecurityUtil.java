package com.cms.basic.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecurityUtil {
	public static String encryptionPassword(String pw){
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(pw.getBytes());
			return new BigInteger(1, md.digest()).toString(16);
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return pw;
		}
		
	}
}
