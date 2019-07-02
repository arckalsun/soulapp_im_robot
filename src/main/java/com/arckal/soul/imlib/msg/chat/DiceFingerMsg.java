package com.arckal.soul.imlib.msg.chat;

/**
 * @Author: arckal
 * @Date: 2019/6/27 19:26
 * @Version 1.0
 */
public class DiceFingerMsg extends TopChatMsg{
    public int looked;
    public int number;

    public DiceFingerMsg(int i, int i2) {
        this.number = i;
        this.looked = i2;
    }

    public DiceFingerMsg(int i) {
        this.number = i;
    }

}
