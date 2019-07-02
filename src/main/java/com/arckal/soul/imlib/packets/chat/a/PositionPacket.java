package com.arckal.soul.imlib.packets.chat.a;

import com.arckal.soul.imlib.msg.chat.PositionMsg;
import com.arckal.soul.protos.MsgCommandOuterClass;
import com.arckal.soul.protos.PositionMessageOuterClass;

/**
 * @Author: arckal
 * @Date: 2019/6/27 22:14
 * @Version 1.0
 */
public class PositionPacket extends MsgPacket {
    public PositionPacket(String str, PositionMsg positionMsg, String str2) {
        super(str, 0, MsgCommandOuterClass.MsgCommand.Type.POSITION, str2);
        this.o = this.p.mergePositionMessage(PositionMessageOuterClass.PositionMessage.newBuilder()
                .setTitle(positionMsg.title == null ? "" : positionMsg.title)
                .setAddress(positionMsg.address == null ? "" : positionMsg.address)
                .setLng(positionMsg.lng)
                .setLat(positionMsg.lat)
                .build()).build();
        c();
    }

}
