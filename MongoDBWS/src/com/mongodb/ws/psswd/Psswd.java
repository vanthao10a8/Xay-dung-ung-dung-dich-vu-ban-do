package com.mongodb.ws.psswd;

import java.util.Random;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Psswd 
{
	private static Random rand = new Random();
	private static String psswd = "";
	public static String crePsswd()
	{
		for(int i = 0; i < 6; i++)
		{
			int randomNum = rand.nextInt(10);
			psswd+= randomNum;
		}
		return psswd;
	}
	public static String hash(String psswd)
	{
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(psswd.getBytes());
			byte byteData[] = md.digest();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			return "errorhashcode";
		}
	}
}
