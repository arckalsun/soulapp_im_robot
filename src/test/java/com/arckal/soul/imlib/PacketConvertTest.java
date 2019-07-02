package com.arckal.soul.imlib;

import com.arckal.soul.SoulApplication;
import com.arckal.soul.imlib.msg.ImMessage;
import com.arckal.soul.imlib.msg.chat.ChatMessage;
import com.arckal.soul.imlib.msg.chat.TextMsg;
import com.arckal.soul.imlib.packets.MyTextPacket;
import com.arckal.soul.imlib.packets.Packet;
import com.arckal.soul.imlib.packets.PacketConverter;
import com.arckal.soul.utils.DataUtils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: arckal
 * @Date: 2019/6/28 10:38
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes={SoulApplication.class})// 指定启动类
public class PacketConvertTest {

    @Test
    public void buildChatPacket(){
        String from = "29885200";
        String to = "390970";
        String msgId = DataUtils.c();
        String text = "123";

        System.out.println("msgid: " + msgId);
        ChatMessage create = ChatMessage.create(from);
        create.setMsgType(1);
        create.setMsgContent(new TextMsg(text));
        final ImMessage createChatSendMsg = ImMessage.createChatSendMsg(create, to, msgId);// 切入分析
        Packet packet = PacketConverter.convert(createChatSendMsg);
        DataUtils.printBytes(packet.b());

        Packet packet1 = new MyTextPacket(from, to, text, msgId);
        DataUtils.printBytes(packet1.b());


    }
}
