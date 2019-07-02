package com.arckal.soul.utils;

import java.util.Collection;

/**
 * @Author: arckal
 * @Date: 2019/6/25 17:15
 * @Version 1.0
 */
public class ListUtils {
    public static boolean isEmpty(Collection collection){
        return collection==null || collection.isEmpty();
    }
}
