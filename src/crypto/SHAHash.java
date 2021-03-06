/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author AZAM
 */
public class SHAHash {
    public static String hash(String data, String algorithm){
        String hashed = "";
        try{
            MessageDigest sha = MessageDigest.getInstance(algorithm);
            sha.update(data.getBytes());
            byte[] byteData = sha.digest();
            //konversi dari byte ke hex
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
            hashed = sb.toString();
        } catch (NoSuchAlgorithmException e) {
        }
        return hashed;
    }
    public static void main(String[] args) {
        String data = "Selamat datang di Politeknik Harapan Bersama Tegal";
        System.out.println("Plain Text: "+data);
        System.out.println("SHA-1\t: "+hash(data, "SHA-1"));
        System.out.println("SHA-256\t: "+hash(data, "SHA-256"));
        System.out.println("SHA-512\t: "+hash(data, "SHA-512"));
    }
    
}
