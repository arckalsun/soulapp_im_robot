package com.arckal.soul.imlib.packets.chat.a;

import com.arckal.soul.imlib.msg.chat.ExtChatMsg;
import com.arckal.soul.protos.ExtChatMessageOuterClass;
import com.arckal.soul.protos.MsgCommandOuterClass;

/**
 * @Author: arckal
 * @Date: 2019/6/27 22:07
 * @Version 1.0
 */
public class ExtPacket extends MsgPacket {
    public ExtPacket(String str, ExtChatMsg extChatMsg, String str2) {
        super(str, 0, MsgCommandOuterClass.MsgCommand.Type.EXT_CMD, str2);
        this.o = this.p.mergeExtChatMessage(ExtChatMessageOuterClass.ExtChatMessage.newBuilder()
                .setContent(extChatMsg.content)
                .setType(extChatMsg.type)
                .build()).build();
        c();
    }

}
