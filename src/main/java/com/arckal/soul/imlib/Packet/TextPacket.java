package com.arckal.soul.imlib.Packet;

import com.arckal.soul.utils.DataUtils;

import java.nio.charset.Charset;

/**
 * @Author: arckal
 * @Date: 2019/5/29 14:02
 * @Version 1.0
 */
public class TextPacket extends CommandPacket {

    static byte[] byteHeader = new byte[]{(byte)0x12}; // 包头
    private String fromId = null;   // 源用户
    private String toId = null;     // 目标用户
    private String textMsg = null;  // 消息体
    private long msgTime = 0l;
    private String nonce = null;

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    public String getToId() {
        return toId;
    }

    public void setToId(String toId) {
        this.toId = toId;
    }

    public String getTextMsg() {
        return textMsg;
    }

    public void setTextMsg(String textMsg) {
        this.textMsg = textMsg;
    }

    public long getMsgTime() {
        return msgTime;
    }

    public void setMsgTime(long msgTime) {
        this.msgTime = msgTime;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public TextPacket(String fromId, String toId, String textMsg){
        this.fromId = fromId;
        this.toId = toId;
        this.textMsg = textMsg;
        this.msgTime = System.currentTimeMillis();
        this.nonce = String.valueOf(System.currentTimeMillis()) + "00000";

    }

    public long length(){
        return this.textMsg.length();
    }

    @Override
    public String toString() {
        return "[文本消息 接收人:"+this.toId+
                "] " + this.textMsg;
    }

    @Override
    public byte[] getData() {
        byte[] data = null;
        int lengthFromId = this.fromId.getBytes().length;
        int lengthToId = this.toId.getBytes().length;
//        int lengthMsg = this.textMsg.getBytes(Charset.forName("UTF-8")).length;

        // 计算消息长度
        int len1 = this.textMsg.getBytes(Charset.forName("UTF-8")).length;
        int d1 = len1 / 0x80;
        byte[] bytes1 = null;
        if(d1>0){
            bytes1 = new byte[]{(byte)(len1 % 0x80+0x80),(byte) d1};
        }else{
            bytes1 = new byte[]{(byte)len1};
        }

        int len2 = len1 + bytes1.length + 1;
        int d2 = len2 / 0x80;
        byte[] bytes2 = null;
        if(d2>0){
//            bytes2 = new byte[]{(byte)len2,(byte) d2};
            bytes2 = new byte[]{(byte)(len2 % 0x80+0x80),(byte) d2};
        }else{
            bytes2 = new byte[]{(byte)len2};
        }

        int len3 = len2 + bytes2.length + 1 + lengthToId+2+lengthFromId+2;
        int d3 = len3 / 0x80;
        byte[] bytes3 = null;
        if(d3>0){
//            bytes3 = new byte[]{(byte)len3,(byte) d3};
            bytes3 = new byte[]{(byte)(len3 % 0x80+0x80),(byte) d3};
        }else{
            bytes3 = new byte[]{(byte)len3};
        }

//        if(lengthMsg)
//
//        int length2a = lengthMsg +1+1+2+lengthToId+2+lengthFromId+2;
//        byte[] length2aBytes = null;
//        if (lengthMsg<=105){
//            length2aBytes = new byte[]{(byte)length2a};
//        }else{
//            length2aBytes = new byte[]{(byte)length2a,(byte)0x01};
//        }
        try {
            data = (byte[]) DataUtils.concatArrays(byteHeader,  // 包头
                    new byte[]{(byte)this.nonce.length()},      // 随机串长度
                    this.nonce.getBytes(),                      // 随机串
                    new byte[]{(byte)0x2a},                     // 固定位 0x2a
                    bytes3,                     // -------------------后面数据包长度和
                    new byte[]{(byte)0x12},                     // 固定位
                    new byte[]{(byte)this.fromId.length()},     // 发送人id长度
                    this.fromId.getBytes(),                     // 发送人id
                    new byte[]{(byte)0x1a},                     // 固定位 0x1a
                    new byte[]{(byte)(this.toId.length())},     // 接收人id长度
                    this.toId.getBytes(),                       // 接收人id
                    new byte[]{(byte)0x32},                     // 固定位 0x32
                    bytes2,               // -------------------消息长度+2
                    new byte[]{(byte)0x0a},                     // 固定位 0x0a
                    bytes1,                   // 消息长度
                    this.textMsg.getBytes(Charset.forName("UTF-8"))                             // 消息
                    );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }


}
