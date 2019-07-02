package com.arckal.soul.imlib.packets.chat;

import com.arckal.soul.protos.CommandMessageOuterClass;
import com.arckal.soul.protos.SyncFinOuterClass;

/**
 * @Author: arckal
 * @Date: 2019/6/25 14:23
 * @Version 1.0
 */
public class SyncFinPacket extends CommandPacket {
    public SyncFinPacket(String readLastMsgId, String timestamp){
        this.m = this.n.mergeSyncFin(
                SyncFinOuterClass.SyncFin.newBuilder()
                    .setReadLastMsgId(readLastMsgId)
                    .setTimestamp(timestamp)
                    .build())
                .setType(CommandMessageOuterClass.CommandMessage.Type.SYNC_FIN)
                .build();

    }
}
