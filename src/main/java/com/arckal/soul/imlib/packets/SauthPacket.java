package com.arckal.soul.imlib.packets;

import com.arckal.soul.protos.SauthMessageOuterClass.SauthMessage;
import com.arckal.soul.protos.SauthMessageOuterClass.SauthMessage.Builder;

/**
 * @Author: arckal
 * @Date: 2019/6/25 17:39
 * @Version 1.0
 */
public class SauthPacket extends BasePacket {
    protected SauthMessage m;

    public SauthPacket(String soulId, String uid, String sid){
        Builder builder = SauthMessage.newBuilder();
        builder.setSid(sid).setSoulId(soulId).setUid(uid);
        this.m = builder.build();
    }

    public String a(){
        return super.a();
    }

    public byte[] b() {
        return this.m.toByteArray();
    }

    public byte[] a(int i) {
        return b(i);
    }

    public byte[] b(int i) {
        byte[] a;
        byte[] bArr = new byte[8];
        bArr[0] = (byte) 1;
        bArr[1] = (byte) 1;
        if (i <= 0) {
            int len = b().length;
            a = new byte[]{(byte) ((len >> 8) & 255), (byte) (len & 255)};
        } else {
            a = new byte[]{(byte) ((i >> 8) & 255), (byte) (i & 255)};
        }
        bArr[2] = a[0];
        bArr[3] = a[1];
        bArr[4] = (byte) 2;
        a = new byte[]{(byte) ((1 >> 8) & 255), (byte) (1 & 255)};
        bArr[5] = a[0];
        bArr[6] = a[1];
        bArr[7] = (byte) 1;
        return bArr;
    }

    public byte[] c() {
        return new byte[]{(byte) 0};
    }

    public SauthMessage d() {
        return this.m;
    }

    public void a(SauthMessage sauthMessage) {
        this.m = sauthMessage;
    }


}
