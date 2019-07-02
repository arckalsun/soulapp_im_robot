package com.arckal.soul.imlib.packets.chat.a;

import com.arckal.soul.protos.MsgCommandOuterClass;
import com.arckal.soul.protos.SnapChatMessageOuterClass;

/**
 * @Author: arckal
 * @Date: 2019/6/27 22:06
 * @Version 1.0
 */
public class SnapChatPacket extends MsgPacket {
    public SnapChatPacket(String str, int i, String str2) {
        super(str, 0, MsgCommandOuterClass.MsgCommand.Type.SNAPCHAT, str2);
        this.o = this.p.mergeSnapChatMessage(SnapChatMessageOuterClass.SnapChatMessage.newBuilder()
                .setMark(i).build()).build();
        c();
    }

}
