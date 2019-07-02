package com.arckal.soul.utils;

import java.io.File;
import ws.schild.jave.*;

/**
 * @Author: arckal
 * @Date: 2019/7/1 14:47
 * @Version 1.0
 */
public class AudioConvertUtils {

    public static boolean convertM4aToWav(String m4aFile, String wavFile){
        try{
            File source = new File(m4aFile);
            File target = new File(wavFile);
            //Audio Attributes
            AudioAttributes audio = new AudioAttributes();
            audio.setCodec("libmp3lame");
            audio.setBitRate(128000);
            audio.setChannels(2);
            audio.setSamplingRate(16000);
            //Encoding attributes
            EncodingAttributes attrs = new EncodingAttributes();
            attrs.setFormat("wav");
            attrs.setAudioAttributes(audio);

            //Encode
            Encoder encoder = new Encoder();
            encoder.encode(new MultimediaObject(source), target, attrs);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

    }

    public static void main(String[] args){
        if(convertM4aToWav("D:\\test\\tmp\\1.m4a","D:\\test\\tmp\\1.wav")){
            System.out.println("转换成功");
        }else{
            System.out.println("转换失败");
        }
    }
}
