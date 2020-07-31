package PasswordEncodeDecode;

import PasswordEncodeDecode.EncodingDecodingPassword;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PasswordEncodeDecodeWithPropertiesFile {
	
	public static void main(String[] args) throws IOException 
	{
		FileReader reader = new FileReader("src/PasswordEncodeDecode/credentialSetting.properties");
		Properties prop = new Properties();
		prop.load(reader);
		String decodePassword = utils.EncryptPassword.decryptPassword(prop.getProperty("password"));
	}	
	
	 public static String decodePassword(String password) {
	    	
	    	// Decode the Password
	        byte[] decodePassword = Base64.decodeBase64(password.getBytes());
	      //  System.out.println("decodePassword: " + new String(decodePassword)); 
	    	
	    	return new String(decodePassword);
	    }
}
