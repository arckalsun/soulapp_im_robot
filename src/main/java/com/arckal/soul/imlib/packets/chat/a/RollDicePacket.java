package com.arckal.soul.imlib.packets.chat.a;

import com.arckal.soul.protos.MsgCommandOuterClass;
import com.arckal.soul.protos.RollDiceMessageOuterClass;

/**
 * @Author: arckal
 * @Date: 2019/6/27 21:51
 * @Version 1.0
 */
public class RollDicePacket extends MsgPacket {
    public RollDicePacket(String str, int i, String str2) {
        super(str, 0, MsgCommandOuterClass.MsgCommand.Type.ROLL_DICE, str2);
        this.o = this.p.mergeRollDiceMessage(RollDiceMessageOuterClass.RollDiceMessage.newBuilder()
                .setDicePoints(i).build()).build();
        c();
    }

}
