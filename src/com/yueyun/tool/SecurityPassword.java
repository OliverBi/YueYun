package com.yueyun.tool;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecurityPassword {
	public static String encryptPassword(String password){
		StringBuffer hexString = new StringBuffer();
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			byte[] srcBytes = password.getBytes(); 
			md5.update(srcBytes);   
			byte[] resultBytes = md5.digest();
			for(int i = 0; i < resultBytes.length; i++){
				password = Integer.toHexString(0xFF&resultBytes[i]);
				if(password.length()<2){
					password ="0"+password;
				}
				hexString.append(password);
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return hexString.toString();
	}
}
