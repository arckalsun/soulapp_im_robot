package com.arckal.soul.imlib.msg.chat;

import com.arckal.soul.utils.GsonUtils;

import java.io.Serializable;

/**
 * @Author: arckal
 * @Date: 2019/6/26 10:54
 * @Version 1.0
 */
public class TopChatMsg implements Serializable {
    public int mark = -1;

    public String toJson(){
        return GsonUtils.toJson((Object) this);
    }
}
