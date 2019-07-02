package com.arckal.soul.service;
import com.arckal.soul.imlib.msg.ImMessage;
import com.arckal.soul.imlib.packets.Packet;
import com.arckal.soul.imlib.TextMsgCommand;
import com.arckal.soul.protos.MsgCommandOuterClass;

/**
 * @Author: arckal
 * @Date: 2019/6/10 0:18
 * @Version 1.0
 */
public interface ChatService {
    /**
     * 判断一句话是否包含敏感词汇
     * @param words
     * @return
     */
    public boolean isSensitive(String words);

    public  void saveMsgCommand(MsgCommandOuterClass.MsgCommand msg);

    public  void saveTextMsgCommand(TextMsgCommand msg);

    public  void saveImMessage(ImMessage msg);

    /**
     * 调用机器人接口
     * @param question
     * @return
     */
    public String askRobot(String question);

    /**
     * 发送消息
     * @param packet
     */
    public void send(Packet packet) ;
}
