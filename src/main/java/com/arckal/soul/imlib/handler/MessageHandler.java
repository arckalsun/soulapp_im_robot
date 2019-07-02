package com.arckal.soul.imlib.handler;

import com.arckal.soul.protos.CommandMessageOuterClass;

import java.util.List;

/**
 * @Author: arckal
 * @Date: 2019/6/25 14:41
 * @Version 1.0
 */
public interface MessageHandler {
    void handle(CommandMessageOuterClass.CommandMessage commandMessage);

    void handle(List<CommandMessageOuterClass.CommandMessage> list);
}
