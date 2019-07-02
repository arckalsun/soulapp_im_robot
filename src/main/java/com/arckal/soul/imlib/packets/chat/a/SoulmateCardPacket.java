package com.arckal.soul.imlib.packets.chat.a;

import com.arckal.soul.protos.MsgCommandOuterClass;
import com.arckal.soul.protos.SoulmateCardMessageOuterClass;

/**
 * @Author: arckal
 * @Date: 2019/6/27 21:54
 * @Version 1.0
 */
public class SoulmateCardPacket extends MsgPacket {
    public SoulmateCardPacket(String str, int i, String str2) {
        super(str, 0, MsgCommandOuterClass.MsgCommand.Type.SOULMATE_CARD, str2);
        this.o = this.p.mergeSoulmateCardMessage(SoulmateCardMessageOuterClass.SoulmateCardMessage.newBuilder()
                .setStatus(i).build()).build();
        c();
    }

}
