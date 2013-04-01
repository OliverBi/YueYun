package com.yueyun.tool;

import java.util.Arrays;

public class VerifyCode {
	public enum VerifyCodeLevel {Simple,Medium,Hard};
	
	public static String getVerifyCode(){
		return getVerifyCode(4,VerifyCodeLevel.Medium,false);
	}
	
	public static String getVerifyCode(int length, VerifyCodeLevel level, boolean isCanRepeat){
		int len = length;
		char[] codes = {'1','2','3','4','5','6','7','8','9',
						'a','b','c','d','e','f','g','h','i',
						'j','k','m','n','p','q','r','s','t',
						'u','v','w','x','y','z','A','B','C',
						'D','E','F','G','H','I','J','K','L',
						'M','N','P','Q','R','S','T','U','V',
						'W','X','Y','Z'};
		if(level == VerifyCodeLevel.Simple){
		    codes = Arrays.copyOfRange(codes, 0,9);
		}else if(level == VerifyCodeLevel.Medium){
		    codes = Arrays.copyOfRange(codes, 0,33);
		}
		
		int n = codes.length;
		
		if(len > n && isCanRepeat == false){
			throw new RuntimeException(String.format("调用SecurityCode.getSecurityCode(%1$s,%2$s,%3$s)出现异常，当isCanRepeat为%3$s时，传入参数%1$s不能大于%4$s",len,level,isCanRepeat,n));
		}
		
		char[] result = new char[len];
		
		if(isCanRepeat){
			for(int i = 0;i < result.length; i++){
				int r = (int)(Math.random()*n);
				result[i] = codes[r]; 
			}
		}else{
			for(int i = 0; i < result.length; i++){
				int r = (int)(Math.random()*n);
				result[i] = codes[r];
				codes[r] = codes[n -1];
				n--;
			}
		}
		return String.valueOf(result);
	}
}
