package com.arckal.soul.imlib.Packet;

/**
 * @Author: arckal
 * @Date: 2019/5/27 16:05
 * @Version 1.0
 */
public interface Packet {

    /**
     * 返回数据体
     * @return
     */
    public byte[] getData();

    /**
     * 返回数据头
     * @return
     */
    public byte[] getHeader(int i);
}
