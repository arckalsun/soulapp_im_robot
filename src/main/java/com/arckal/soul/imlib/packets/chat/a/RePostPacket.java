package com.arckal.soul.imlib.packets.chat.a;

import com.arckal.soul.protos.MsgCommandOuterClass;
import com.arckal.soul.protos.RepostMessgeOuterClass;

/**
 * @Author: arckal
 * @Date: 2019/6/27 21:43
 * @Version 1.0
 */
public class RePostPacket extends MsgPacket {
    public RePostPacket(String from, String info, String cmdId, MsgCommandOuterClass.MsgCommand.Type type) {
        super(from, 0, type, cmdId);
        this.o = this.p.mergeRepostMessge(RepostMessgeOuterClass.RepostMessge.newBuilder()
                .setInfo(info).build()).build();
        c();
    }

}
