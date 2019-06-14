package com.arckal.soul.imlib.Packet;

/**
 * @Author: arckal
 * @Date: 2019/5/30 9:58
 * @Version 1.0
 */
public class PingPacket implements Packet {
    /**
     * 返回数据体
     *
     * @return
     */
    @Override
    public byte[] getData() {
        return null;
    }

    /**
     * 返回数据头
     *
     * @param i
     * @return
     */
    @Override
    public byte[] getHeader(int i) {
        return new byte[]{(byte) 1, (byte) 0};
    }
}
