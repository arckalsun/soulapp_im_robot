package com.arckal.soul.imlib.packets.chat.a;

import com.arckal.soul.imlib.msg.chat.TextMsg;
import com.arckal.soul.protos.MsgCommandOuterClass.MsgCommand.Type;
import com.arckal.soul.protos.TextMsgOuterClass;


/**
 * @Author: arckal
 * @Date: 2019/6/26 11:52
 * @Version 1.0
 */
public class TextPacket extends MsgPacket {
    public TextPacket(String to, Type type, TextMsg textMsg, String cmdId){
        super(to,0,type,cmdId);
        this.o = this.p.mergeTextMsg(TextMsgOuterClass.TextMsg.newBuilder()
                .setText(textMsg.text)
                .setType(textMsg.type)
                .build())
                .build();
        c();
    }

    public TextPacket(String to, Type type, String text, String cmdId) {
        super(to, 0, type, cmdId);
        this.o = this.p.mergeTextMsg(TextMsgOuterClass.TextMsg.newBuilder()
                .setText(text).build()).build();
        c();
    }

}
