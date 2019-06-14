package com.arckal.soul.imlib.Packet;

import com.arckal.soul.utils.DataUtils;

/**
 * @Author: arckal
 * @Date: 2019/5/29 10:45
 * @Version 1.0
 */
public class AuthPacket implements Packet {
    /**
     * 认证包
     * 0a 08 3239383835323030 1218 572f793178795072504851444150314e6c41383733776d4c 1a20 476e6d6b6668564e746d6252354c4c432b376e4a6735766358572b3153796563
     */
    static byte[] byte1 = new byte[]{(byte)0x0a}; // 包头
    static byte[] byte2 = new byte[]{(byte)0x12,(byte)0x18};
    static byte[] byte3 = new byte[]{(byte)0x1a,(byte)0x20};
    private String soulId = null;
    private String deviceId = null;
    private String authToken = null;


    public AuthPacket(String soulId,String deviceId, String authToken){
        this.soulId = soulId;
        this.authToken = authToken;
        this.deviceId = deviceId;
    }

    public byte[] getData(){
        byte[] byteSoulId = this.soulId.getBytes();
        byte[] byteDeviceId = this.deviceId.getBytes();
        byte[] byteAuthToken = this.authToken.getBytes();

        byte[]data = (byte[]) DataUtils.concatArrays(byte1,
                new byte[]{(byte)byteSoulId.length},
                byteSoulId,
                byte2,
                byteDeviceId,
                byte3,
                byteAuthToken);
        return data;

    }

    /**
     * 返回数据头
     *
     * @return
     */
    @Override
    public byte[] getHeader(int i) {
        byte[] a;
        byte[] bArr = new byte[8];
        bArr[0] = (byte) 1;
        bArr[1] = (byte) 1;
        if (i <= 0) {
            int len = getData().length;
            a = new byte[]{(byte) ((len >> 8) & 255), (byte) (len & 255)};
        } else {
            a = new byte[]{(byte) ((i >> 8) & 255), (byte) (i & 255)};
        }
        bArr[2] = a[0];
        bArr[3] = a[1];
        bArr[4] = (byte) 2;
//        a = cn.soulapp.main.java.imlib.g.a.a(1);
        a = new byte[]{(byte) ((1 >> 8) & 255), (byte) (1 & 255)};
        bArr[5] = a[0];
        bArr[6] = a[1];
        bArr[7] = (byte) 1;
        return bArr;
    }
}
