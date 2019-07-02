package com.arckal.soul.imlib.handler;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: arckal
 * @Date: 2019/6/25 13:51
 * @Version 1.0
 */
public class MsgHandlerProvider {
    private Map<Integer, MessageHandler> map;

    private static class Singleton{
        static MsgHandlerProvider instance = new MsgHandlerProvider();
        private Singleton(){

        }
    }

    public static MsgHandlerProvider getInstance(){
        return Singleton.instance;
    }

    private MsgHandlerProvider(){
        this.map = new HashMap<>();
        this.map.put(Integer.valueOf(3),new AckHandler());
        this.map.put(Integer.valueOf(0),new ChatHandler());
        this.map.put(Integer.valueOf(6),new NotifyHandler());
        this.map.put(Integer.valueOf(2),new PshHandler());
        this.map.put(Integer.valueOf(5),new RespHandler());
        this.map.put(Integer.valueOf(7),new PushHandler());
    }

    public MessageHandler getHandler(int i){
        return this.map.get(Integer.valueOf(i));
    }
}
