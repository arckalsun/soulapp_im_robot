package com.arckal.soul.imlib.Packet;

/**
 * @Author: arckal
 * @Date: 2019/5/29 13:45
 * @Version 1.0
 */
public class SyncPacket implements Packet {
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
        return new byte[0];
    }
}
