package com.arckal.soul.imlib.packets.chat.a;

import com.arckal.soul.imlib.msg.chat.ExpressionMsg;
import com.arckal.soul.protos.MsgCommandOuterClass;
import com.arckal.soul.protos.UserExpressionMessageOuterClass;

/**
 * @Author: arckal
 * @Date: 2019/6/27 21:45
 * @Version 1.0
 */
public class UserExpressionPacket extends MsgPacket {
    public UserExpressionPacket(String str, ExpressionMsg expressionMsg, String str2) {
        super(str, 0, MsgCommandOuterClass.MsgCommand.Type.USER_EXPRESSION, str2);
        this.o = this.p.mergeUserExpressionMessage(UserExpressionMessageOuterClass.UserExpressionMessage.newBuilder()
                .setImageUrl(expressionMsg.imageUrl)
                .setImageW((float) expressionMsg.imageW)
                .setImageH((float) expressionMsg.imageH)
                .build()).build();
        c();
    }

}
