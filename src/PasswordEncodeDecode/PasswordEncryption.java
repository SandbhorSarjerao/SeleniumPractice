package PasswordEncodeDecode;

// import java.util.Base64;
 import org.apache.commons.codec.binary.Base64;

public class PasswordEncryption {
	
	// Using org.apache.commons.codec.binary.Base64
	public static String encodePassword(String password) {
	        // Encode the Password
	        byte[] ecodedPassword = Base64.encodeBase64(password.getBytes());
	    	return new String(ecodedPassword);
	}
	    
	// Using org.apache.commons.codec.binary.Base64
	public static String decodePassword(String password) {
	    	// Decode the Password
	        byte[] decodePassword = Base64.decodeBase64(password); 
	    	return new String(decodePassword);
	}
	
//	// Using java.util.Base64
//	public static String encryptPassword(String password) {
//        // Encode the Password
//        byte[] ecodedPassword = Base64.getEncoder().encode(password.getBytes());    	
//    	return new String(ecodedPassword);
//    }
//    
//	// Using java.util.Base64
//   public static String decryptPassword(String encryptedPassword) {
//    	// Decode the Password
//        byte[] decodePassword = Base64.getDecoder().decode(encryptedPassword);    	
//    	return new String(decodePassword);
//    }

}
