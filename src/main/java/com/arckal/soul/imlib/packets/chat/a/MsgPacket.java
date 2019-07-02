package com.arckal.soul.imlib.packets.chat.a;

import com.arckal.soul.SoulConfig;
import com.arckal.soul.imlib.packets.chat.CommandPacket;
import com.arckal.soul.protos.CommandMessageOuterClass;
import com.arckal.soul.protos.MsgCommandOuterClass.MsgCommand;
import com.arckal.soul.protos.MsgCommandOuterClass.MsgCommand.Type;
import com.arckal.soul.utils.SpringContextUtil;

/**
 * @Author: arckal
 * @Date: 2019/6/26 10:36
 * @Version 1.0
 */
public class MsgPacket extends CommandPacket {
    protected MsgCommand o;
    protected MsgCommand.Builder p = MsgCommand.newBuilder();

    public MsgPacket(String to, int snapchat, Type type, String cmdId){
        super(cmdId);
        MsgCommand.Builder builder1 = this.p.setFrom(SpringContextUtil.getBean(SoulConfig.class).getUserId());
        if(to==null){
            to = "";
        }
        // FIXME: 待定
        builder1.setTo(to).setSnapChat(snapchat).setType(type);
        this.n.setType(CommandMessageOuterClass.CommandMessage.Type.MSG);
    }

    public MsgPacket(String to, int snapchat, Type type, String cmdId, String notice) {
        super(cmdId);
        MsgCommand.Builder a = this.p.setFrom(SpringContextUtil.getBean(SoulConfig.class).getUserId());
        if (to == null) {
            to = "";
        }
        // FIXME: 待定
        MsgCommand.Builder a2 = a.setTo(to).setSnapChat(snapchat).setType(type);
        if (notice == null) {
            notice = "";
        }
        a2.setNotice(notice);
        this.n.setType(CommandMessageOuterClass.CommandMessage.Type.MSG);
    }

    public void c() {
        this.m = this.n.setMsgCommand(this.o).build();
    }

}
