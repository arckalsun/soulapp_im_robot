package com.arckal.soul.imlib.handler;

import com.arckal.soul.protos.CommandMessageOuterClass;
import com.arckal.soul.protos.RespCommandOuterClass;

/**
 * @Author: arckal
 * @Date: 2019/6/25 17:04
 * @Version 1.0
 */
public class RespHandler extends HandlerAdapter {
    @Override
    public void handle(CommandMessageOuterClass.CommandMessage commandMessage) {
        super.handle(commandMessage);
        RespCommandOuterClass.RespCommand respCommand = commandMessage.getRespCommand();
        if(respCommand.getType() != RespCommandOuterClass.RespCommand.Type.MSG){
            System.out.println("[resp error msg]: "+respCommand.getErrorMsg());
            System.out.println(respCommand);
        }

    }
}
