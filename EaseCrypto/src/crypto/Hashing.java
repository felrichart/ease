package crypto;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.apache.commons.codec.binary.Base64;

public class Hashing {
	
	public static String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[20];
        random.nextBytes(bytes);
        return new Base64().encodeToString(bytes);
    }
	
	public static String SHA(String toHash, String salt) {
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}		
		toHash = toHash + salt;
		byte[] bToHash = new Base64().decode(toHash);
		byte[] hashed = digest.digest(bToHash);
		
		return new Base64().encodeToString(hashed);		
	}

}
