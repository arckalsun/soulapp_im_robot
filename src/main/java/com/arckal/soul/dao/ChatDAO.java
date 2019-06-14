package com.arckal.soul.dao;

import com.arckal.soul.imlib.MsgCommand;
import com.arckal.soul.utils.MongoUtil;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @Author: arckal
 * @Date: 2019/6/3 10:17
 * @Version 1.0
 */
@Component
public class ChatDAO {

    @Autowired
    private  MongoUtil mongoUtil;
    // 获取数据库
    private static String mdb = "soulapp";
    private static String mcol = "chat";

    @Autowired
    public ChatDAO(MongoUtil mongoUtil){
        this.mongoUtil = mongoUtil;
    }

    // 保存数据
    public  void saveMsgCommand(MsgCommand msg){
        MongoCollection<Document> collection = this.mongoUtil.getCollection(mdb, mcol);
        Document doc = new Document();
        doc.put("fromUserId",  msg.getFromUserId());
        doc.put("toUserId",msg.getToUserId());
        doc.put("msgText",msg.getMessage());
        doc.put("msgTime",msg.getMsgTime());
        collection.insertOne(doc);
    }

    // 获取敏感词
    public HashSet<String> getSensitiveWords(){
        HashSet<String> words = new HashSet<>();
        MongoCollection<Document> collection = this.mongoUtil.getCollection(mdb, "sensitive_words");
        MongoCursor<Document> cursor = collection.find().iterator();
        try{
            while (cursor.hasNext()) {
                Document  document = cursor.next();
                words.add(document.getString("words"));
            }
        } finally {
            cursor.close();
        }
        return words;
    }

    // 统计消息数量
    public  int getMsgCount(){
        MongoCollection<Document> collection = this.mongoUtil.getCollection(mdb, mcol);
        return mongoUtil.getCount(collection);
    }
    // 统计用户数量
    public  int getUserCount(){
        return 0;
    }
}
