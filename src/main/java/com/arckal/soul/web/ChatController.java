package com.arckal.soul.web;

import com.arckal.soul.imlib.ChatReply;
import com.arckal.soul.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: arckal
 * @Date: 2019/7/3 10:05
 * @Version 1.0
 */
@RestController
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    private ChatService chatService;

    @RequestMapping(value="/askRobot")
    public ChatReply ask(String q, HttpServletRequest request, HttpServletResponse response) throws Exception{
        if(!StringUtils.isEmpty(q)){
            return chatService.askRobot("webapi",q);
        }else{
            return null;
        }
    }

    @RequestMapping(value="/isSensitive")
    public boolean isSensitive(String words, HttpServletRequest request, HttpServletResponse response) throws Exception{
        if(!StringUtils.isEmpty(words)){
            return chatService.isSensitive(words);
        }else{
            return false;
        }
    }

}
