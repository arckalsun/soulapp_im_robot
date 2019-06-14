package com.arckal.soul.dao;

import com.arckal.soul.utils.MongoUtil;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: arckal
 * @Date: 2019/5/31 18:03
 * @Version 1.0
 */
public class UserDAO {
    // 获取数据库
    private static String mdb = "soulapp";
    private static String mcol = "users_hz";

    @Autowired
    private static MongoUtil mongoUtil;

    public static List<String> findHZUsers(){
        List<String> users = new LinkedList<>();
        MongoCollection<Document> collection = mongoUtil.getCollection(mdb, mcol);

        MongoCursor<Document>  cursor = collection.find(Filters.eq("genderelation", 1)).iterator();
        try{
            while (cursor.hasNext()) {
                Document  document = cursor.next();
                users.add(document.getString("userAppVersion.userId"));
            }
        } finally {
            cursor.close();
        }
        return users;
    }

//    public static void main(String[] args) throws Exception {
//        System.out.println("start...");
//        List<String> users = UserDAO.findHZUsers();
//        System.out.println(users.size());
//
//    }

}
