package com.arckal.soul.utils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;


/*** 
 * DES ECB PKCS5Padding 对称加密 解密
 *
 *
 */
public class DESTest {

    private static SecretKey getSK(String str) throws NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException {
//        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DES");
//        KeySpec keySpec = new DESKeySpec(str.getBytes());
//        return secretKeyFactory.generateSecret(keySpec);
        SecretKeyFactory localSecretKeyFactory = SecretKeyFactory.getInstance("DES");
        KeySpec paramString = new DESKeySpec(str.getBytes());
        localSecretKeyFactory.generateSecret(paramString);
        return localSecretKeyFactory.generateSecret(paramString);
    }

    /**
     * * 加密数据
     * * @param encryptString
     * * @param encryptKey
     * * @return
     * * @throws Exception
     */
    public static String encryptDES(String encryptString, String encryptKey) throws Exception {

        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, getSK(encryptKey));
        byte[] encryptedData = cipher.doFinal(encryptString.getBytes("UTF-8"));
        return a.a(encryptedData);
//        return DESTest.strToBytes(cipher.doFinal(encryptString.getBytes()));
//        return Base64.encodeBase64String(encryptedData);
    }


    /***
     * 解密数据
     * @param decryptString
     * @param decryptKey
     * @return
     * @throws Exception
     */


    public static String decryptDES(String decryptString, String decryptKey) throws Exception {

//        byte[] sourceBytes = Base64.decodeBase64(decryptString);
        byte[] sourceBytes = a.a(decryptString.toCharArray());
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, getSK(decryptKey));
        byte[] decoded = cipher.doFinal(sourceBytes);
        return new String(decoded, "UTF-8");

    }

    public static String ecpt2Base64(String str){
        // 将UserIdEcpt转为UserId的base64
        // WCtkcXpydkhtSk09
        // X+dqzrvHmJM=
        return Ecpt.toBase64(str);

    }

//    public static void main(String[] args) throws Exception {
//        String clearText = "390970";
//        String key = "123!@#zaqXSWqwer";//密钥
//        System.out.println("明文：" + clearText + "\n密钥：" + key);
//        String encryptText = encryptDES(clearText, key);
//        System.out.println("加密后：" + encryptText);
//        encryptText = "j5LBqN/Fifw94Ii/zSWHmeaBkgTk9Ps1K6StDwbPsz5poWhJgHZsVQ==";
//        String decryptText = decryptDES(encryptText, key);
//        System.out.println("解密后：" + decryptText);
//
//        System.out.printf("Ecpt2Base64:" + ecpt2Base64("WCtkcXpydkhtSk09"));
//    }

    /* compiled from: DESUtil */
    static class a {
        private static char[] a = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".toCharArray();
        private static byte[] b = new byte[256];

        a() {
        }

        static {
            int i;
            for (i = 0; i < 256; i++) {
                b[i] = (byte) -1;
            }
            for (i = 65; i <= 90; i++) {
                b[i] = (byte) (i - 65);
            }
            for (i = 97; i <= 122; i++) {
                b[i] = (byte) ((i + 26) - 97);
            }
            for (i = 48; i <= 57; i++) {
                b[i] = (byte) ((i + 52) - 48);
            }
            b[43] = (byte) 62;
            b[47] = (byte) 63;
        }

        static String a(byte[] bArr) {
            char[] cArr = new char[(((bArr.length + 2) / 3) * 4)];
            int i = 0;
            int i2 = 0;
            while (i2 < bArr.length) {
                Object obj;
                Object obj2;
                int i3 = (bArr[i2] & 0xFF) << 8;
                if (i2 + 1 < bArr.length) {
                    i3 |= bArr[i2 + 1] & 0xFF;
                    obj = 1;
                } else {
                    obj = null;
                }
                i3 <<= 8;
                if (i2 + 2 < bArr.length) {
                    i3 |= bArr[i2 + 2] & 0xFF;
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                cArr[i + 3] = a[obj2 != null ? i3 & 63 : 64];
                int i4 = i3 >> 6;
                int i5 = i + 2;
                char[] cArr2 = a;
                if (obj != null) {
                    i3 = i4 & 63;
                } else {
                    i3 = 64;
                }
                cArr[i5] = cArr2[i3];
                i3 = i4 >> 6;
                cArr[i + 1] = a[i3 & 63];
                cArr[i + 0] = a[(i3 >> 6) & 63];
                i2 += 3;
                i += 4;
            }
            return new String(cArr);
        }

        static byte[] a(char[] cArr) throws Exception {
            int i = 0;
            int length = ((cArr.length + 3) / 4) * 3;
            if (cArr.length > 0 && cArr[cArr.length - 1] == '=') {
                length--;
            }
            if (cArr.length > 1 && cArr[cArr.length - 2] == '=') {
                length--;
            }
            byte[] bArr = new byte[length];
            int i2 = 0;
            int i3 = 0;
            for (char c : cArr) {
                byte b1 = b[c & 0xFF];
                if (b1 >= (byte) 0) {
                    int i4 = i2 << 6;
                    i2 = i3 + 6;
                    i3 = i4 | b1;
                    if (i2 >= 8) {
                        int i5 = i2 - 8;
                        i2 = i + 1;
                        bArr[i] = (byte) ((i3 >> i5) & 0xFF);
                        i = i2;
                        i2 = i3;
                        i3 = i5;
                    } else {
                        int i6 = i3;
                        i3 = i2;
                        i2 = i6;
                    }
                }
            }
            if (i == bArr.length) {
                return bArr;
            }
            throw new Exception("miscalculated data length!");
        }
    }

}  
