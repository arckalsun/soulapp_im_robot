package com.arckal.soul.imlib.packets.chat;

import com.arckal.soul.imlib.connection.PacketWriter;
import com.arckal.soul.imlib.handler.AckHandler;
import com.arckal.soul.protos.CommandMessageOuterClass;
import com.arckal.soul.protos.CommandMessageOuterClass.CommandMessage.Type;
import com.arckal.soul.protos.SyncCommandOuterClass;
import com.arckal.soul.protos.MsgFinOuterClass.MsgFin.Status;

/**
 * @Author: arckal
 * @Date: 2019/5/29 13:45
 * @Version 1.0
 */
public class SyncPacket extends CommandPacket {

    public SyncPacket(String startMsgId, String startTimestamp, CommandMessageOuterClass.CommandMessage.Type type){
        this.m = this.n.setType(type).mergeSyncCommand(
                SyncCommandOuterClass.SyncCommand.newBuilder().setStartMsgId(startMsgId)
                .setStartTimestamp(startTimestamp).build()).build();
    }

    public SyncPacket(String startMsgId, String startTimestamp, String endMsgId, String endTimestamp){
        this.m = this.n.setType(Type.SYNC).mergeSyncCommand(SyncCommandOuterClass.SyncCommand.newBuilder()
        .setStartMsgId(startMsgId).setStartTimestamp(startTimestamp)
        .setEndMsgId(endMsgId).setEndTimestamp(endTimestamp).build()).build();
    }

    public static void a(String startMsgId, String startTimestamp) {
        if (startMsgId == null) {
            startMsgId = "";
        }
        if (startTimestamp == null) {
            startTimestamp = "";
        }
        // TODO: 发送数据包
        PacketWriter.sendPacket(new SyncPacket(startMsgId, startTimestamp, Type.SYNC));
        AckHandler.setStatus(Status.DOING);
    }

    public static void a(String startMsgId, String startTimestamp, String endMsgId, String endTimestamp) {
        PacketWriter.sendPacket(new SyncPacket(startMsgId, startTimestamp, endMsgId, endTimestamp));
        AckHandler.setStatus(Status.DOING);
    }

    public static void b(String startMsgId, String startTimestamp) {
        if (startMsgId == null) {
            startMsgId = "";
        }
        if (startTimestamp == null) {
            startTimestamp = "";
        }
        PacketWriter.sendPacket(new SyncPacket(startMsgId, startTimestamp, Type.FIRST_SYNC));
        AckHandler.setStatus(Status.DOING);
    }

}
