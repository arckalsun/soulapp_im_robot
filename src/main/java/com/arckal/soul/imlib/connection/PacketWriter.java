package com.arckal.soul.imlib.connection;

import com.arckal.soul.imlib.packets.Packet;
import com.arckal.soul.imlib.SoulChatClient;
import com.arckal.soul.utils.SpringContextUtil;

/**
 * @Author: arckal
 * @Date: 2019/5/28 11:00
 * @Version 1.0
 */
public class PacketWriter {
    private static SoulChatClient client;

    /**
     * 发送数据包
     * @param packet
     */
    public static void sendPacket(Packet packet){

        try {
            if(client==null || packet==null){
                client = SpringContextUtil.getBean(SoulChatClient.class);
            }
            client.send(packet);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
