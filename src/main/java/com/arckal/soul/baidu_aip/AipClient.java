package com.arckal.soul.baidu_aip;

import com.arckal.soul.utils.FileUtil;
import com.arckal.soul.utils.HttpRequest;
import com.baidu.aip.speech.AipSpeech;
import com.baidu.aip.speech.TtsResponse;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;

/**
 * 静态内部类实现单例，可以保证多线程的对象唯一性，还有提升性能，不用同步锁机制
 */
@Component
public class AipClient {

    //设置APPID/AK/SK
    @Value("${baiduaip.app_id}")
    public String APP_ID;

    @Value("${baiduaip.app_key}")
    public String API_KEY;

    @Value("${baiduaip.secret_key}")
    public String SECRET_KEY;

    private AipSpeech client;


//    public AipClient(String appId, String apiKey, String secret_key){
//        this.APP_ID = appId;
//        this.API_KEY = apiKey;
//        this.SECRET_KEY = secret_key;
//        client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);
//    }

    @PostConstruct
    public void initialize(){
        client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);
    }

    public String parseVoice(String voicepath){
        String result = "";
        try {
            // 调用接口
            JSONObject res = client.asr(voicepath, "wav", 16000, null);
            System.out.println(res);
            if(res.getInt("err_no")==0){
                JSONArray results = res.getJSONArray("result");
                result = results.get(0).toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            return result;
        }
    }

    /**
     * 解析音频
     * https://img.soulapp.cn/audio/2019-07-01/9afcbfd8-d023-47d8-ac37-809036734e6a.m4a
     * @param voiceUrl
     * @return
     */
    public String parseVoiceFromUrl(String voiceUrl){
//        String filename = FileUtil.getFileName(voiceUrl);
        int index = voiceUrl.lastIndexOf("/");
        String filename = voiceUrl.substring(index);
//        String path = "D:\\test\\tmp";
        String path = "./";
        try {
            HttpRequest.downLoadFromUrl(voiceUrl,filename,path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parseVoice(path + File.separator+filename);
    }

    public AudioFile toVoice(String text, String filePath){
        // 调用接口
        AudioFile audioFile = new AudioFile();
        HashMap<String, Object> options = new HashMap<String, Object>();
        options.put("spd", "5");
        options.put("pit", "5");
        options.put("per", "4");
        TtsResponse res = client.synthesis(text, "zh", 1, options);
//        TtsResponse res = client.synthesis(text, "zh", 1, null);
        byte[] data = res.getData();
        JSONObject res1 = res.getResult();
        if (data != null) {
            try {
                File file = new File(filePath) ; // 建立文件
                if (!file.exists()) file.createNewFile() ;
                FileOutputStream fos = new FileOutputStream(file) ;
                ObjectOutputStream oos = new ObjectOutputStream(fos) ;
                oos.writeObject(data);
                //获取音频时长
                MP3File f = (MP3File) AudioFileIO.read(file);
                MP3AudioHeader audioHeader = (MP3AudioHeader)f.getAudioHeader();
                int length = audioHeader.getTrackLength();
                oos.close();
                fos.close();
                audioFile.setFilename(filePath);
                audioFile.setDuration(length);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return audioFile;
    }


}
