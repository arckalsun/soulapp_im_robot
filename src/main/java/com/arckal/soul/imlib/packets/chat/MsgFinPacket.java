package com.arckal.soul.imlib.packets.chat;

import com.arckal.soul.protos.MsgFinOuterClass.MsgFin;
import com.arckal.soul.protos.MsgFinOuterClass.MsgFin.Status;
import com.arckal.soul.protos.CommandMessageOuterClass.CommandMessage.Type;

/**
 * @Author: arckal
 * @Date: 2019/6/25 16:02
 * @Version 1.0
 */
public class MsgFinPacket extends CommandPacket {

    public MsgFinPacket(String readLastMsgId, String timestamp, Status status){
        this.m = this.n.mergeMsgFin(MsgFin.newBuilder().setReadLastMsgId(readLastMsgId)
                .setTimestamp(timestamp)
                .setStatus(status).build()).setType(Type.MSG_FIN).build();
    }
}
