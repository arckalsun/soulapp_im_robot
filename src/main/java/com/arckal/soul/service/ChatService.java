package com.arckal.soul.service;

import com.arckal.soul.imlib.MsgCommand;

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

    public  void saveMsgCommand(MsgCommand msg);

    /**
     * 调用机器人接口
     * @param question
     * @return
     */
    public String askRobot(String question);
}
