package com.arckal.soul.imlib.msg.chat;

import com.arckal.soul.protos.UserExpressionMessageOuterClass;

/**
 * @Author: arckal
 * @Date: 2019/6/27 19:26
 * @Version 1.0
 */
public class ExpressionMsg extends TopChatMsg{
    public int imageH;
    public String imageUrl;
    public int imageW;

    public ExpressionMsg(){

    }

    public static ExpressionMsg convert(UserExpressionMessageOuterClass.UserExpressionMessage userExpressionMessage) {
        ExpressionMsg expressionMsg = new ExpressionMsg();
        expressionMsg.imageUrl = userExpressionMessage.getImageUrl();
        expressionMsg.imageW = (int) userExpressionMessage.getImageW();
        expressionMsg.imageH = (int) userExpressionMessage.getImageH();
        return expressionMsg;
    }

    public ExpressionMsg(String imageUrl, int imageH, int imageW) {
        this.imageUrl = imageUrl;
        this.imageH = imageH;
        this.imageW = imageW;
    }

}
