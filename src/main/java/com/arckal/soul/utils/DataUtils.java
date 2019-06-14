package com.arckal.soul.utils;

import com.arckal.soul.imlib.Packet.CmdPacket;
import com.arckal.soul.imlib.Packet.Packet;
import org.apache.myfaces.shared_impl.util.ArrayUtils;

import java.util.UUID;

/* compiled from: DataUtils */
public class DataUtils {
    public static String a() {
        return UUID.randomUUID().toString();
    }

    public static String b() {
        return UUID.randomUUID().toString().substring(28, 36);
    }

    public static String c() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("%013d", new Object[]{Long.valueOf(System.currentTimeMillis())}));
        stringBuilder.append(String.format("%05d", new Object[]{Long.valueOf((long) (Math.random() * 100000.0d))}));
        return stringBuilder.toString();
    }


    public static void printBytes(byte[] bytes){
//        System.out.println();
        for (byte i : bytes
        ) {
            System.out.printf(String.format("%02x",i));
        }
        System.out.println();
    }

    public static String bytesToHexString(byte[] src){
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    public static byte[] hexStrToBytes(String str){
        byte[] result = null;
        int hexLen = str.length()/2;
        result = new byte[hexLen];

        for(int i=0;i<hexLen;i++){
            result[i] = (byte) Integer.parseInt(str.substring(i*2,i*2+2),16);
        }
        return result;
    }

    public static int gaa(byte[] bArr, int i){
        return (bArr[i + 3] & 255) | ((((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16)) | ((bArr[i + 2] & 255) << 8));
    }
    public static Object concatArrays(Object... arrs){
        return ArrayUtils.concat(arrs);
    }

    public static void main(String[] args){
//        Packet packet = new AuthPacket("29885200","W/y1xyPrPHQDAP1NlA873wmL","GnmkfhVNtmbR5LLC+7nJg5vcXW+1Syec");
//        Packet packet = new TextPacket("29885200","3909702","我是小哥哥,hahaha");
        Packet packet = new CmdPacket("29885200","390970",true);
        byte[] data = packet.getData();
        printBytes(data);
    }
}
