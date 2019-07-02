package com.arckal.soul.utils;
import com.google.gson.Gson;
/**
 * @Author: arckal
 * @Date: 2019/6/26 10:56
 * @Version 1.0
 */
public class GsonUtils {
    public static <T> T fromJson(String str, Class<T> cls){
        try{
            return new Gson().fromJson(str, cls);
        }catch (Exception e){
            return null;
        }
    }
    public static <T> String toJson(T t) {
        try {
            return new Gson().toJson((Object) t);
        } catch (Exception unused) {
            return null;
        }
    }

}
