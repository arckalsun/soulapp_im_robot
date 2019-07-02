package com.arckal.soul.imlib.packets;

/**
 * @Author: arckal
 * @Date: 2019/5/27 16:05
 * @Version 1.0
 */
public interface Packet {

    String a();

    /**
     * 返回数据头
     * @return
     */
    byte[] a(int i);

    /**
     * 返回数据体
     * @return
     */
    byte[] b();


}
