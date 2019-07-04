package com.arckal.soul.utils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;


/**
 * @Author: arckal
 * @Date: 2019/5/27 10:55
 * @Version 1.0
 */
public class EncryptUtils {
    public static final String key = "123!@#zaqXSWqwer";
    private static final String algorithm = "DES";

    public static byte[] encrypt(byte[] bArr){
        try{
            Cipher instance = Cipher.getInstance(algorithm);
            instance.init(1,a(key));
            return instance.doFinal(bArr);
        }catch (Exception unused){
            return bArr;
        }
    }

    public static byte[] decrypt(byte[] bArr){
        try{
            Cipher instance = Cipher.getInstance("DES/ECB/pkcs5padding");
            instance.init(2,a(key));
            return instance.doFinal(bArr);
        }catch (Exception unused){
            return bArr;
        }
    }

    private static SecretKey a(String str) throws NoSuchAlgorithmException,InvalidKeySpecException,
            InvalidKeyException{
        SecretKeyFactory instance = SecretKeyFactory.getInstance(algorithm);
        KeySpec dESKeySpec = new DESKeySpec(str.getBytes());
        instance.generateSecret(dESKeySpec);
        return instance.generateSecret(dESKeySpec);
    }

    public static byte[] sign(int i) {
        return new byte[]{(byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    public static void main(String[] args){
//        byte[] plainText = "arckal".getBytes();
//        System.out.println("plainText: " + new String(plainText));
//        byte[] ciperText = EncryptUtils.encrypt(plainText);
//        byte[] ciperText = DataUtils.hexStrToBytes("1d56506c5e8a6d5f0d759665bc7b8feaee8474e3e0246d6967151c7746a712287deb451c6f85194048bde5d932a2527d2f64f7066a298f254603cbfd648627c4260182049a79e503e6f31a380aba22895aecf0553b05a1fcc67300a833a96c86660e55a6eed023ab");
        byte[] ciperText = DataUtils.hexStrToBytes("964428161b25217584789277c83861aec5b00c4e7f8dd5bbd8b8fed74940ae5beabbfcdb4418c0095a29ff6eab8fb3efbee3237ad0be47003dec9f80e2710102");
//        System.out.println("ciperText: " + Arrays.toString(ciperText));
        byte[] decryptText = EncryptUtils.decrypt(ciperText);
        DataUtils.printBytes(decryptText);

    }
}
