package com.arckal.soul.imlib.packets.chat.a;

import com.arckal.soul.protos.FingerGuessMessageOuterClass;
import com.arckal.soul.protos.MsgCommandOuterClass;

/**
 * @Author: arckal
 * @Date: 2019/6/27 21:50
 * @Version 1.0
 */
public class FingerGuessPacket extends MsgPacket {
    public FingerGuessPacket(String str, int i, String str2) {
        super(str, 0, MsgCommandOuterClass.MsgCommand.Type.FINGER_GUESS, str2);
        this.o = this.p.mergeFingerGuessMessage(FingerGuessMessageOuterClass.FingerGuessMessage.newBuilder()
                .setFinger(i).build()).build();
        c();
    }

}
