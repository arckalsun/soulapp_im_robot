package com.arckal.soul.imlib.msg.push;

import java.io.Serializable;
import java.util.Map;

/**
 * @Author: arckal
 * @Date: 2019/6/27 18:48
 * @Version 1.0
 */
public class PushMsg implements Serializable {
    public Map<String, String> extMap;
    public String text;
    public String title;

    public String getExt(String str) {
        if (this.extMap == null) {
            return "";
        }
        str = (String) this.extMap.get(str);
        if (str == null) {
            str = "";
        }
        return str;
    }

    public PushMsg(String title, String text, Map<String, String> extMap) {
        this.title = title;
        this.text = text;
        this.extMap = extMap;
    }

}
