package com.arckal.soul.imlib.Packet;

import com.arckal.soul.utils.EncryptUtils;

/**
 * @Author: arckal
 * @Date: 2019/5/30 10:14
 * @Version 1.0
 */
public class CommandPacket implements Packet {
    /**
     * 返回数据体
     *
     * @return
     */
    @Override
    public byte[] getData() {
        return new byte[0];
    }

    /**
     * 返回数据头
     *
     * @param i
     * @return
     */
    @Override
    public byte[] getHeader(int i) {
        byte[] a;
        byte[] bArr = new byte[5];
        bArr[0] = (byte) 1;
        bArr[1] = (byte) 2;
        if (i <= 0) {
            a = EncryptUtils.sign(getData().length);
        } else {
            a = EncryptUtils.sign(i);
        }
        bArr[2] = a[0];
        bArr[3] = a[1];
        bArr[4] = (byte) 1;
        return bArr;
    }
}
