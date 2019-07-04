package com.arckal.soul.thread;

import com.arckal.soul.dao.ChatDAO;
import com.arckal.soul.imlib.SoulChatClient;
import com.arckal.soul.dao.UserRedisDAO;
import com.arckal.soul.imlib.packets.Packet;
import com.arckal.soul.imlib.packets.chat.a.TextPacket;
import com.arckal.soul.utils.SpringContextUtil;

import java.util.Observable;

/**
 * @Author: arckal
 * @Date: 2019/6/2 9:48
 * @Version 1.0
 */

public class RedisListenThread  extends Observable implements Runnable {

    private UserRedisDAO userRedisDAO;

//    private ChatDAO chatDao;

    private SoulChatClient client;

    public RedisListenThread(UserRedisDAO userRedisDAO,SoulChatClient client){
        this.userRedisDAO = userRedisDAO;
//        chatDao = SpringContextUtil.getBean(ChatDAO.class);
        this.client = client;
    }

    @Override
    public void run() {
        while(true){
            try{
                Packet packet=null;
                // 文本包
                do{
                    packet = userRedisDAO.nextPacket(client.getSoulId());
                    if(packet!=null){
                        client.send(packet);
                    }
                    // 延迟，频率过快会被封号
//                    Thread.sleep(500);
                } while (packet!=null);

                // 同步包
//                do{
//                    packet = userRedisDAO.nextSyncPacket();
//                    if(packet!=null){
//                        System.out.printf("-->> 发送同步包:");
//                        System.out.println(packet.toString());
////                        SoulChatClient.getInstance().send(textPacket);
//                        client.send(packet);
//                    }
//                    // 延迟，频率过快会被封号
//                    Thread.sleep(500);
//                } while (packet!=null);
//
//                // 同步包2
//                do{
//                    packet = userRedisDAO.nextSyncPacket_SYNC();
//                    if(packet!=null){
//                        System.out.printf("-->> 发送同步包2:");
//                        System.out.println(packet.toString());
////                        SoulChatClient.getInstance().send(textPacket);
//                        client.send(packet);
//                    }
//                    // 延迟，频率过快会被封号
//                    Thread.sleep(500);
//                } while (packet!=null);

                Thread.sleep(100);
            }catch (Exception e){
                e.printStackTrace();
                break;
            }

        }
    }
}
