package PasswordEncodeDecode;

import org.apache.commons.codec.binary.Base64;


public class EncodingDecodingPassword {
    public static void main(String[] args){
        String password = "Test123";
        System.out.println("Orignal Password: " + password);

        // Encode the Password
        // byte[] ecodedPassword = Base64.encodeBase64(password.getBytes());
        // System.out.println("encodePassword: " + new String(ecodedPassword));
        
        // Decode the Password
        // byte[] decodePassword = Base64.decodeBase64(ecodedPassword);
        // System.out.println("decodePassword: " + new String(decodePassword));  
        
        
        System.out.println("encodePassword: " + encodePassword(password));
        System.out.println("decodePassword: " + decodePassword(encodePassword(password)));
    }
    
    public static String encodePassword(String password) {
    	
    //	System.out.println("Orignal Password: " + password);

        // Encode the Password
        byte[] ecodedPassword = Base64.encodeBase64(password.getBytes());
      //  System.out.println("encodePassword: " + new String(ecodedPassword));
    	
    	return new String(ecodedPassword);
    }
    
    public static String decodePassword(String password) {
    	
    	// Decode the Password
        byte[] decodePassword = Base64.decodeBase64(password);
      //  System.out.println("decodePassword: " + new String(decodePassword)); 
    	
    	return new String(decodePassword);
    }
}
