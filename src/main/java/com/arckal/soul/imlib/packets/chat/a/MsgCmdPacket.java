package com.arckal.soul.imlib.packets.chat.a;

import com.arckal.soul.protos.MsgCommandOuterClass.MsgCommand.Type;

/**
 * @Author: arckal
 * @Date: 2019/6/26 11:12
 * @Version 1.0
 */
public class MsgCmdPacket extends MsgPacket {
    public MsgCmdPacket(String to,Type type, String cmdId){
        super(to, 0, type, cmdId);
        this.o = this.p.build();
        c();
    }
}
