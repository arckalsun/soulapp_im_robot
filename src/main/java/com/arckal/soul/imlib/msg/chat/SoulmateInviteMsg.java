package com.arckal.soul.imlib.msg.chat;

/**
 * @Author: arckal
 * @Date: 2019/6/27 19:37
 * @Version 1.0
 */
public class SoulmateInviteMsg extends TopChatMsg {
    public static final int AGREE = 1;
    public static final int NONE = 0;
    public static final int REFUSE = 2;
    public int status;

    public SoulmateInviteMsg(int i) {
        this.status = i;
    }
}