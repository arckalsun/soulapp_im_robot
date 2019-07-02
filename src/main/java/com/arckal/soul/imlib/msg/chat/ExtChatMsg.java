package com.arckal.soul.imlib.msg.chat;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Author: arckal
 * @Date: 2019/6/27 19:35
 * @Version 1.0
 */
public class ExtChatMsg extends TopChatMsg {
    public String content;
    public int type;

    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        public static final int d = 4;
        public static final int e = 5;
    }

    public ExtChatMsg(String str, int i) {
        this.content = str;
        this.type = i;
    }
}