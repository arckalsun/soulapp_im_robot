package com.arckal.soul.imlib.handler;

import com.arckal.soul.imlib.packets.chat.MsgFinPacket;
import com.arckal.soul.imlib.packets.chat.SyncFinPacket;
import com.arckal.soul.imlib.packets.chat.SyncPacket;
import com.arckal.soul.imlib.connection.PacketWriter;
import com.arckal.soul.protos.AckCommandOuterClass;
import com.arckal.soul.protos.CommandMessageOuterClass;
import com.arckal.soul.protos.MsgFinOuterClass.MsgFin.Status;

/**
 * @Author: arckal
 * @Date: 2019/6/25 14:04
 * @Version 1.0
 */
public class AckHandler extends HandlerAdapter {
    private static Status status = Status.TODO;

    public static synchronized void setStatus(Status status1){
        synchronized (AckHandler.class){
            status = status1;
        }
    }

    @Override
    public void handle(CommandMessageOuterClass.CommandMessage commandMessage) {
        AckCommandOuterClass.AckCommand ackCommand = commandMessage.getAckCommand();
//        i.chat(ackCommand.getReadLastMsgId(), ackCommand.getTimestamp());
        if (commandMessage.getAckCommand().getRemain()) {
            SyncPacket.a(ackCommand.getReadLastMsgId(), ackCommand.getTimestamp());
        } else if (ackCommand.getTypeValue() == 1) {
            // TODO: 发送数据包
            PacketWriter.sendPacket(new SyncFinPacket(ackCommand.getReadLastMsgId(), ackCommand.getTimestamp()));
            setStatus(Status.DONE);
        } else {
            // TODO: 发送数据包
            PacketWriter.sendPacket(new MsgFinPacket(ackCommand.getReadLastMsgId(), ackCommand.getTimestamp(), status));
        }

    }


}
