package com.arckal.soul;

import com.arckal.soul.imlib.Packet.CmdPacket;
import com.arckal.soul.imlib.Packet.Packet;
import com.arckal.soul.imlib.Packet.TextPacket;
import com.arckal.soul.imlib.SoulChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author: arckal
 * @Date: 2019/6/4 10:13
 * @Version 1.0
 */
@Component
@Order(1)
public class SoulApplicationRunner implements ApplicationRunner {

    @Autowired
    private SoulChatClient client;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("\r\n--------------> SoulChatClient Startup <-------------\r\n");
        // 创建客户端
//        SoulChatClient client =  SoulChatClient.getInstance();
//        SoulChatClient client =  new SoulChatClient();
        client.start();

        // 构造数据包
        String toUserId = "29885200";
        Packet textPacket = new TextPacket(client.getSoulId(),toUserId,"hello,arckal");
        Packet typeStartPacket = new CmdPacket(client.getSoulId(),toUserId,true);
        Packet typeEndPacket = new CmdPacket(client.getSoulId(),toUserId,false);

        // 发送指令包
//        System.out.println("发送指令包：输入中");
        client.send(typeStartPacket);
        Thread.sleep(1000);
//        System.out.println("发送指令包：输入结束");
        client.send(typeEndPacket);
        // 发送消息包
        System.out.printf("-->> 发送:");
        System.out.println(textPacket.toString());
        client.send(textPacket);

    }
}
