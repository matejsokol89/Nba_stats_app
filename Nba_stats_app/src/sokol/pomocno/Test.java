/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokol.pomocno;

import java.security.SecureRandom;
import java.security.spec.KeySpec;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 *
 * @author Profesor
 */
public class Test {



    public Test() {

        try {
            
            byte[] salt = new byte[16];
            salt="1214525214525252".getBytes();
            KeySpec spec = new PBEKeySpec("mojaLozinka".toCharArray(), salt, 65536, 128);
            SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");

            byte[] hash = f.generateSecret(spec).getEncoded();
            Base64.Encoder enc = Base64.getEncoder();
            System.out.printf("salt: %s%n", enc.encodeToString(salt));
            System.out.printf("hash: %s%n", enc.encodeToString(hash));
        } catch (Exception e) {
        }
    }
    public static void main(String[] args) {
        new Test();
    }
}
