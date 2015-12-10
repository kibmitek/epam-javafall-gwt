package com.epam.javafall2015.gwt.shared;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.sql.ResultSet;
import java.util.Base64;
import java.util.Random;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class UseJDBC {

	public static void main(String[] args) {
		JDBCHelper helper = new JDBCHelper();
		ResultSet rs = helper.executeQuery("select now()");
		
		
		
		byte[] salt = new byte[16];
		Random random = new Random();
		random.nextBytes(salt);
		KeySpec spec = new PBEKeySpec("password".toCharArray(), salt, 65536, 128);
		SecretKeyFactory f = null;
		try {
			f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		byte[] hash;
		try {
			hash = f.generateSecret(spec).getEncoded();
			Base64.Encoder enc = Base64.getEncoder();
			System.out.printf("salt: %s%n", enc.encodeToString(salt));
			System.out.printf("hash: %s%n", enc.encodeToString(hash));
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
		
		
		spec = new PBEKeySpec("password".toCharArray(), salt, 65536, 128);
		f = null;
		try {
			f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		try {
			hash = f.generateSecret(spec).getEncoded();
			Base64.Encoder enc = Base64.getEncoder();
			System.out.printf("salt: %s%n", enc.encodeToString(salt));
			System.out.printf("hash: %s%n", enc.encodeToString(hash));
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
