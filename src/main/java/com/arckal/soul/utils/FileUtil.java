package com.arckal.soul.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: arckal
 * @Date: 2018/12/12 16:00
 * @Version 1.0
 */
public class FileUtil {

    public static String readToString(InputStream in) {
        String encoding = "UTF-8";
        try{
            final int bufferSize = 1024;
            final char[] buffer = new char[bufferSize];
            final StringBuilder out = new StringBuilder();
            Reader reader = new InputStreamReader(in,encoding);
            for(;;){
                int rsz = reader.read(buffer, 0, buffer.length);
                if (rsz < 0)
                    break;
                out.append(buffer,0,rsz);
            }
            return out.toString();
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public static String getFileName(String path){
        String[] arr = path.split("/");
        return arr[arr.length-1];
    }

    /**
     * 根据行读取内容
     * @return
     */
    public static List<String> getFileContent(InputStream in) {
        List<String> strList = new ArrayList<String>();
//        File file = new File(path);
        InputStreamReader read = null;
        BufferedReader reader = null;
        try {
            read = new InputStreamReader(in,"utf-8");
            reader = new BufferedReader(read);
            String line;
            while ((line = reader.readLine()) != null) {
                strList.add(line);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (read != null) {
                try {
                    read.close();
                } catch (IOException e) {
                    // Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    // Auto-generated catch block
                    e.printStackTrace();
                }
            }

        }
        return strList;
    }

}
