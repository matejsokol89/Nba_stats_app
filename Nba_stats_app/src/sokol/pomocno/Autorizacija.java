/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokol.pomocno;

import sokol.model.Operater;
import java.security.spec.KeySpec;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import org.hibernate.Session;

/**
 *
 * @author Profesor
 */
public class Autorizacija {
    
    public static String getHash(String lozinka){
         try {
            
            byte[] salt = new byte[16];
            salt="1214525214525252".getBytes();
            KeySpec spec = new PBEKeySpec(lozinka.toCharArray(), salt, 65536, 128);
            SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");

            byte[] hash = f.generateSecret(spec).getEncoded();
            Base64.Encoder enc = Base64.getEncoder();
            return enc.encodeToString(hash);
        } catch (Exception e) {
            
        }
         
         return String.valueOf(Math.random());
    }
    
    public static Operater autoriziraj(String email, char[] lozinka){
        Session session = HibernateUtil.getSession();
        System.out.println(getHash(String.valueOf(lozinka)));
        return (Operater)session.createQuery("from Operater o where "
                + " o.email=:email and o.lozinka=:lozinka")
                .setString("email", email)
                .setString("lozinka", getHash(String.valueOf(lozinka)))
                .uniqueResult();
        
        
    }
    
}
