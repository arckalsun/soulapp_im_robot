package com.arckal.soul.imlib.msg.chat;

import com.arckal.soul.SoulConfig;
import com.arckal.soul.utils.SpringContextUtil;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @Author: arckal
 * @Date: 2019/6/27 18:04
 * @Version 1.0
 */
public class ChatMessage implements Serializable {
    public String extString;
    private HashMap<String, Serializable> maps = new HashMap();
    public int msgType;
    public String notice;
    public String sessionId;
    public int snapChat;

    /**
     * 创建ChatMessage
     * @param fromId 发送人id
     * @return ChatMessage
     */
    public static ChatMessage create(String fromId) {
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setSessionId(createSessionId(fromId));
        return chatMessage;
    }

    public static String createSessionId(String fromId) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(SpringContextUtil.getBean(SoulConfig.class).getUserId());
        stringBuilder.append(fromId);
//        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }

    public <T extends Serializable> void put(String str, T t) {
        this.maps.put(str, t);
    }

    public <T> T getObj(String str) {
        try {
            return (T)this.maps.get(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public int getMsgType() {
        return this.msgType;
    }

    public <T extends Serializable> T getMsgContent() {
        return (T) getObj("MSGCONTENT");
    }

    public int getSnapChat() {
        return this.snapChat;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public void setMsgType(int i) {
        this.msgType = i;
    }

    public <T extends Serializable> void setMsgContent(T t) {
        put("MSGCONTENT", t);
    }

    public void setSnapChat(int i) {
        this.snapChat = i;
    }

    public void putExt(String str, Serializable serializable) {
        put(str, serializable);
    }

    public <T> T getExt(String str) {
        return getObj(str);
    }

    public String getExtString() {
        return this.extString;
    }

    public void setExtString(String str) {
        this.extString = str;
    }

    public String getNotice() {
        return this.notice;
    }

    public void setNotice(String str) {
        this.notice = str;
    }

}
