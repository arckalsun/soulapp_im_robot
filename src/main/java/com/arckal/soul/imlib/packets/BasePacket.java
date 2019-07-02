package com.arckal.soul.imlib.packets;

import com.arckal.soul.protos.CommandMessageOuterClass;
import com.arckal.soul.utils.DataUtils;

/**
 * @Author: arckal
 * @Date: 2019/6/25 14:08
 * @Version 1.0
 */
public class BasePacket implements Packet {
    public static final int a = 5;
    public static final int b = 5;
    public static final int c = 2;
    public static final int d = 0;
    public static final int e = 1;
    public static final int f = 2;
    public static final int g = 1;
    public static final int h = 1;
    public static final int i = 1;
    public static final int j = 0;
    protected CommandMessageOuterClass.CommandMessage k;
    protected CommandMessageOuterClass.CommandMessage.Builder builder = CommandMessageOuterClass.CommandMessage.newBuilder();

    public String a(){
        return null;
    }

    public byte[] b(int i){
        return null;
    }

    public BasePacket() {
        this.builder.setCmdId(DataUtils.c());
    }

    public byte[] b() {
        return new byte[0];
    }

    public byte[] a(int i) {
        return b(i);
    }


}
