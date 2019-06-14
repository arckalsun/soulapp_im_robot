package com.arckal.soul.imlib.thread;

import com.arckal.soul.imlib.SoulChatClient;
import com.arckal.soul.dao.UserRedisDAO;
import com.arckal.soul.imlib.Packet.Packet;

import java.util.Observable;

/**
 * @Author: arckal
 * @Date: 2019/6/2 9:48
 * @Version 1.0
 */

public class RedisListenThread  extends Observable implements Runnable {

    private UserRedisDAO userRedisDAO;

    private SoulChatClient client;

    public RedisListenThread(UserRedisDAO userRedisDAO,SoulChatClient client){
        this.userRedisDAO = userRedisDAO;
        this.client = client;
    }

    @Override
    public void run() {
        while(true){
            try{
                Packet textPacket=null;
                do{
                    textPacket = userRedisDAO.nextTextPacket(client.getSoulId());
                    if(textPacket!=null){
                        System.out.printf("-->> 发送:");
                        System.out.println(textPacket.toString());
//                        SoulChatClient.getInstance().send(textPacket);
                        client.send(textPacket);
                    }
                } while (textPacket!=null);
//                System.out.println("发送完毕");
                Thread.sleep(10000);
            }catch (Exception e){
                e.printStackTrace();
                break;
            }

        }
    }
}
