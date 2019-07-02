package com.arckal.soul.imlib.packets.chat.a;

import com.arckal.soul.protos.MsgCommandOuterClass;
import com.arckal.soul.protos.UserCardMessageOuterClass;

/**
 * @Author: arckal
 * @Date: 2019/6/27 21:48
 * @Version 1.0
 */
public class UserCardPacket extends MsgPacket {
    public UserCardPacket(String str, String str2, String str3) {
        super(str, 0, MsgCommandOuterClass.MsgCommand.Type.USER_CARD, str3);
        this.o = this.p.mergeUserCardMessage(UserCardMessageOuterClass.UserCardMessage.newBuilder()
                .setUserInfo(str2).build()).build();
        c();
    }

}
