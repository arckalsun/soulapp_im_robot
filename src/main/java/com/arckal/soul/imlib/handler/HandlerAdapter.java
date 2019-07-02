package com.arckal.soul.imlib.handler;


import com.arckal.soul.protos.CommandMessageOuterClass;

import java.util.List;

/**
 * @Author: arckal
 * @Date: 2019/6/25 14:41
 * @Version 1.0
 */
public abstract class HandlerAdapter implements MessageHandler {

    public void handle(CommandMessageOuterClass.CommandMessage commandMessage){
//        System.out.println("[Handler " + this.getClass().getName()+ " ] ");
//        System.out.println(commandMessage);
    };

    public void handle(List<CommandMessageOuterClass.CommandMessage> list){
        for(int i=0;i<list.size();i++){
            handle(list.get(i));
        }
    };
}
