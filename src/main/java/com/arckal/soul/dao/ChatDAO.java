package com.arckal.soul.dao;

import com.arckal.soul.imlib.TextMsgCommand;
import com.arckal.soul.imlib.msg.ImMessage;
import com.arckal.soul.imlib.msg.chat.*;
import com.arckal.soul.protos.MsgCommandOuterClass.MsgCommand;
import com.arckal.soul.utils.MongoUtil;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import static com.mongodb.client.model.Filters.*;


/**
 * @Author: arckal
 * @Date: 2019/6/3 10:17
 * @Version 1.0
 */
@Component
public class ChatDAO {
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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
        switch (msg.getType()){
            case TEXT:
                saveChat("",msg.getFrom(),msg.getTo(),msg.getTextMsg().getText(),msg.getTimestamp(),"TEXT");
                break;
            case VOICE:
                saveChat("",msg.getFrom(),msg.getTo(),msg.getVoiceMessage().getWord(),msg.getTimestamp(),"VOICE");
                break;
            case PIC:
                saveChat("",msg.getFrom(),msg.getTo(),msg.getPicMessage().getImageUrl(),msg.getTimestamp(),"PIC");
                break;
            case USER_EXPRESSION:
                saveChat("",msg.getFrom(),msg.getTo(),msg.getUserExpressionMessage().getImageUrl(),msg.getTimestamp(),"USER_EXPRESSION");
                break;
            case POSITION:
                saveChat("",msg.getFrom(),msg.getTo(),msg.getPositionMessage().getAddress(),msg.getTimestamp(),"POSITION");
                break;
        }

    }

    // 保存数据
    public  void saveTextMsgCommand(TextMsgCommand msg){
        saveChat("",msg.getFromUserId(),msg.getToUserId(),msg.getMessage(),msg.getMsgTime(),"TEXT");
    }

    private void saveChat(String msgId, String from, String to, String text, long timestamp, String msgType){

        MongoCollection<Document> collection = this.mongoUtil.getCollection(mdb, mcol);
        Document doc = new Document();
        doc.put("msgId",  msgId);
        doc.put("fromUserId",  from);
        doc.put("toUserId",to);
        doc.put("msgText",text);
        doc.put("msgTime",timestamp);
        doc.put("msgTimeStr",sdf.format(new Date()));
        doc.put("msgType",msgType);
        collection.insertOne(doc);
    }

    public void saveImMessage(ImMessage msg){
        String content = "";
        String msgType = "";
        switch (msg.getChatMessage().getMsgType()){
            case 1:
                content = ((TextMsg)msg.getChatMessage().getMsgContent()).text;
                msgType = "TEXT";
                break;
            case 2:
                content = ((ImgMsg)msg.getChatMessage().getMsgContent()).imageUrl;
                msgType = "PIC";
                break;
            case 8:
                content = ((ExpressionMsg)msg.getChatMessage().getMsgContent()).imageUrl;
                msgType = "USER_EXPRESSION";
                break;
            case 5:
                content = ((AudioMsg)msg.getChatMessage().getMsgContent()).word;
                msgType = "VOICE";
                break;
            case 33:
                content = ((PositionMsg)msg.getChatMessage().getMsgContent()).address;
                msgType = "POSITION";
                break;
            default:
                content = "MsgType: " + String.valueOf(msg.getChatMessage().getMsgType());
                msgType = "UNKONWN";
                break;
        }
        saveChat(msg.msgId,msg.getFrom(),msg.getTo(),content,msg.getLocalTime(),msgType);
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

    /**
     * 获取用户聊天数量
     * @param uid
     * @return
     */
    public long getUserChatCount(String uid){
        MongoCollection<Document> collection = this.mongoUtil.getCollection(mdb, mcol);
        Bson filter = Filters.eq("fromUserId",uid);
        return collection.count(filter);
    }

    /**
     * 获取最新的n条用户聊天记录
     * @param uid
     * @param n
     * @return
     */
    public List<String> getUserLastChat(String uid, int n){
        MongoCollection<Document> collection = this.mongoUtil.getCollection(mdb, mcol);
        Bson filter = Filters.eq("fromUserId",uid);
//        collection.find(and(gte("stars", 2), lt("stars", 5), eq("categories", "Bakery")))
//                .sort(Sorts.ascending("name"))
//                .iterator()
        MongoCursor<Document> cursor = collection.find(filter).sort(Sorts.descending("msgTime")).limit(n).iterator();
        List<String> list = new ArrayList<>();
        try{
            while (cursor.hasNext()) {
                Document  document = cursor.next();
                list.add(document.getString("msgText"));
            }
        } finally {
            cursor.close();
        }
        return list;
    }

    // 统计用户数量
    public  int getUserCount(){
        return 0;
    }
}
