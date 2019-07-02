package com.arckal.soul.imlib.packets.chat;

import com.arckal.soul.imlib.packets.BasePacket;
import com.arckal.soul.protos.CommandMessageOuterClass;
import com.arckal.soul.utils.EncryptUtils;

/**
 * @Author: arckal
 * @Date: 2019/5/30 10:14
 * @Version 1.0
 */
public class CommandPacket extends BasePacket {
    protected CommandMessageOuterClass.CommandMessage m;
    protected CommandMessageOuterClass.CommandMessage.Builder n;

    public CommandPacket(){
        this.n = CommandMessageOuterClass.CommandMessage.newBuilder();
    }

    public CommandPacket(String cmdId){
        this.n = CommandMessageOuterClass.CommandMessage.newBuilder()
                .setCmdId(cmdId);
//                .setSoulId(SpringContextUtil.getBean(SoulConfig.class).getUserId());
    }

    @Override
    public byte[] a(int i){
        return b(i);
    }

    @Override
    public byte[] b(){
        return this.m.toByteArray();
    }

    @Override
    public byte[] b(int i) {
        byte[] a;
        byte[] bArr = new byte[5];
        bArr[0] = (byte) 1;
        bArr[1] = (byte) 2;
        if (i <= 0) {
            a = EncryptUtils.sign(b().length);
        } else {
            a = EncryptUtils.sign(i);
        }
        bArr[2] = a[0];
        bArr[3] = a[1];
        bArr[4] = (byte) 1;
        return bArr;
    }
}
