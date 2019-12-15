package nc.Medas.config;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashAlgorithm {


    //Хэшируем пароли в SHA-512 так сказатб
    public static String hash(String key) {
        String answer = "";
        try {
            byte[] hashArray = MessageDigest.getInstance("SHA-512").digest(key.getBytes());
            BigInteger hashed = new BigInteger(1,hashArray);
            answer = hashed.toString(16);
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
        }
        return answer;
    }
}
