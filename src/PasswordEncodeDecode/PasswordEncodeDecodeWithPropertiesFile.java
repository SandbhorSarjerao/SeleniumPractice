package PasswordEncodeDecode;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.codec.binary.Base64;

public class PasswordEncodeDecodeWithPropertiesFile {

	public static void main(String[] args) throws IOException {
		FileReader reader = new FileReader("src/PasswordEncodeDecode/credentialSetting.properties");
		Properties prop = new Properties();
		prop.load(reader);
		System.out.println("Original Password: " + prop.getProperty("password"));
		// String decodePassword =
		// utils.EncryptPassword.decryptPassword(prop.getProperty("password"));
		String encodePassword = encryptPassword(prop.getProperty("password"));
		System.out.println("Encrypted Password: " + encodePassword);

		String decodePassword = decryptPassword(encryptPassword(prop.getProperty("password")));
		System.out.println("Decrypted Password: " + decodePassword);
	}

	public static String encryptPassword(String password) {
		// Encode the Password
		byte[] encodePassword = Base64.encodeBase64(password.getBytes());
		// System.out.println("encodePassword: " + new String(encodePassword));

		return new String(encodePassword);
	}

	public static String decryptPassword(String password) {
		// Decode the Password
		byte[] decodePassword = Base64.decodeBase64(password.getBytes());
		// System.out.println("decodePassword: " + new String(decodePassword));

		return new String(decodePassword);
	}
}
