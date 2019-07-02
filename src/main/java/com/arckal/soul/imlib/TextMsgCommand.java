package com.arckal.soul.imlib;

import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * @Author: arckal
 * @Date: 2019/5/31 11:24
 * @Version 1.0
 */
public class TextMsgCommand extends Command {

    private String fromUserId;
    private String toUserId;
    private String message;
    private long msgTime;

    public TextMsgCommand(String fromUserId,String toUserId,String message,long msgTime){
        this.fromUserId = fromUserId;
        this.toUserId = toUserId;
        this.message = message;
        this.msgTime = msgTime;
    }

    public String getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(String fromUserId) {
        this.fromUserId = fromUserId;
    }

    public String getToUserId() {
        return toUserId;
    }

    public void setToUserId(String toUserId) {
        this.toUserId = toUserId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getMsgTime() {
        return msgTime;
    }

    public void setMsgTime(long msgTime) {
        this.msgTime = msgTime;
    }

    public static Command parseFrom(byte[] bytes) {
            int curPos = 0;
            if (bytes.length < 64)
                return null;
            String fromUserId = new String(Arrays.copyOfRange(bytes,2,2+bytes[1]));
            curPos = bytes[1] + 3;
            // 时间戳
            String timeStr = new String(Arrays.copyOfRange(bytes,curPos+1,curPos+bytes[curPos]));
            curPos = curPos+bytes[curPos]+3;
            String fromUserId1 = new String(Arrays.copyOfRange(bytes,curPos+2,curPos+2+bytes[curPos+1]));
            curPos = curPos+2+bytes[curPos+1];
            String toUserId = new String(Arrays.copyOfRange(bytes,curPos+2,curPos+2+bytes[curPos+1]), Charset.forName("UTF-8"));
            curPos = curPos+2+bytes[curPos+1];   //313233 0a221803421e120d 31353539323233393132363330 1a0d31353539323233393132363139
            curPos += 10;
            int msgLen = bytes[curPos];
            String message = new String(Arrays.copyOfRange(bytes,curPos+1,curPos+1+msgLen), Charset.forName("UTF-8"));
            curPos = curPos+1+msgLen;
            curPos += 7;
            int timeLen = bytes[curPos];
            String timeStr1 = new String(Arrays.copyOfRange(bytes,curPos+1,curPos+1+timeLen));

            return new TextMsgCommand(fromUserId,toUserId,message,Long.parseLong(timeStr1));
    }


    @Override
    public String toString() {
        return "[文本消息 发送人:" + this.fromUserId + "] " + this.message;
    }
}
