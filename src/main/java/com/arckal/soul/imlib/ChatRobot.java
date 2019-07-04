package com.arckal.soul.imlib;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.arckal.soul.baidu_aip.AudioFile;
import com.arckal.soul.utils.FileUtil;
import com.arckal.soul.utils.HttpRequest;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

@Component
public class ChatRobot {
    // 机器人接口配置文件
    InputStream fileRobotConfig;

    @Value("${robot.url}")
    private String robotCallback;

    @Value("${robot.rewardUrl}")
    private String rewardUrl;

    private List<String> listAudio;
    private List<String> listReplies;
    private List<String> listReplace;
    private List<String> listPreset;
    private List<Map<String,String>> robots;
    private int currentRobot = 0;



    /**
     * 初始化
     */
    @PostConstruct
    private void initialize() throws IOException {
        // 随机回复语
        InputStream fileRandomReplies = new ClassPathResource("random_replies.txt").getInputStream();
        // 图灵机器人的替换语
        InputStream fileRobotReplaces = new ClassPathResource("robot_replaces.txt").getInputStream();
        // 预设问答文件
        InputStream filePresetReplies = new ClassPathResource("preset_replies.txt").getInputStream();
        // 声音文件
//    File fileAudio = new ClassPathResource("audio.txt").getFile();
        fileRobotConfig = new ClassPathResource("robots.json").getInputStream();

//        listAudio = FileUtil.getFileContent(fileAudio);
        listReplies = FileUtil.getFileContent(fileRandomReplies);
        listReplace = FileUtil.getFileContent(fileRobotReplaces);
        listPreset = FileUtil.getFileContent(filePresetReplies);
        // 解析机器人配置文件，json
        readRobotCfg();
    }

    private void readRobotCfg(){
        try {
            robots = new ArrayList<>();
            String jsonString = FileUtil.readToString(fileRobotConfig);
            JSONArray array = JSON.parseArray(jsonString);
            for(int i=0;i<array.size();i++){
                JSONObject jsonObject = array.getJSONObject(i);
                Map<String,String> robot = new HashMap<>();
                robot.put("apiUrl",jsonObject.getString("apiUrl"));
                robot.put("apiKey",jsonObject.getString("apiKey"));
                robot.put("userId",jsonObject.getString("userId"));
                robots.add(robot);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
//    /**
//     * 随机取一个声音文件路径
//     * @return   文件名|时长
//     */
//    public AudioFile randomAudio(){
//        Random index = new Random();
//        int i = index.nextInt(listAudio.size());
//        String line = listAudio.get(i);
//        AudioFile audioFile = new AudioFile();
//        String[] arr = line.split("\\|");
////        Log.i("soulapp",arr[0]);
//        if(arr.length==2){
//            int length = Integer.parseInt(arr[1]);
//            audioFile.setFilename(dir + arr[0]);
//            audioFile.setDuration(length);
//        }
//        return audioFile;
//    }
    /**
     * 创建图灵机器人接口的请求json
     * @param msg
     * @return
     */
    private static String createJson(String msg,String apiKey,String userId)  {
        JSONObject jsonObject = new JSONObject();
        Map<String,Object> perception = new HashMap<>();
        Map<String,Object> inputText = new HashMap<>();
        Map<String,Object> inputImage = new HashMap<>();
        Map<String,Object> location = new HashMap<>();
        Map<String,Object> selfInfo = new HashMap<>();
        Map<String,Object> userInfo = new HashMap<>();
        inputText.put("text",msg);
        inputImage.put("url","");
        location.put("city","杭州");
        location.put("province","浙江");
        location.put("street","蒋墩路");
        selfInfo.put("location",location);
        perception.put("inputText",inputText);
        perception.put("inputImage",inputImage);
        perception.put("selfInfo",selfInfo);
        userInfo.put("apiKey",apiKey);
        userInfo.put("userId",userId);

        jsonObject.put("reqType",0);
        jsonObject.put("perception",perception);
        jsonObject.put("userInfo",userInfo);
        String ret = jsonObject.toJSONString();
        return ret;

    }

    /**
     * 解析图灵机器人接口返回的json数据
     * @param jsonString
     * @return
     */
    private static String parseAnswer(String jsonString){
        String text = null;
        try{
            JSONObject js = JSON.parseObject(jsonString);
            JSONArray results = js.getJSONArray("results");
            JSONObject values = results.getJSONObject(0).getJSONObject("values");
            text = values.getString("text");
        }catch (Exception e){
            //Log.e("soulapp",e.getMessage());
            e.printStackTrace();
        }
        return text;

    }

    /**
     * 随机回复
     * @return
     */
    public  ChatReply randomReply(){
//        List<String> listTxt = FileUtil.getFileContent(fileRandomReplies);
        ChatReply reply = new ChatReply();
        Random index = new Random();
        int i = index.nextInt(listReplies.size());
        String randomMsg = listReplies.get(i);
        reply.setText(randomMsg);
        reply.setType("RANDOM_REPLY");
        return reply;
    }

    /**
     * 替换图灵机器人的回答
     * @param answer
     * @return
     */
    public  ChatReply handle_answer(String answer){
        ChatReply reply = new ChatReply();
        listReplace.add("请求次数超限制!");
        if(null!=answer && answer.contains("请求次数超限制!")){
            //机器人次数用完，切换到下一个
            System.out.println("soulapp 机器人["+String.valueOf(currentRobot)+"]次数用完，切换下一个机器人");
            currentRobot = currentRobot + 1;
//            if(currentRobot>=robots.size()){
//                currentRobot=0;
//            }
            return null;

        }
        if(null!=listReplace && listReplace.contains(answer)){
            return null;
        }else{
            reply.setText(answer);
            reply.setType("ROBOT_REPLY");

        }
        return reply;
    }

    /**
     * 预设问答集
     * @param message
     * @return
     */
    public  String presetReply(String message){
        String ret = "";
        if(null==message)
            return ret;
        // 文件内容格式：关键字#回复语
        //匹配问答
        for(String line : listPreset){
            String[] arr = line.split("#");
            if(arr.length==2){
                String keyword = arr[0];
                String reply = arr[1];
                if(message.contains(keyword)){
                    ret = reply;
                }
            }
        }
        return ret;
    }
    /**
     * 提问
     * @param message
     * @return
     */
    public  ChatReply ask(String message){
        // 先判断是否在设定的回答范围内
        ChatReply reply=null;
        try {
            String answer = null;
            if(currentRobot<robots.size()){
                String apiUrl = robots.get(currentRobot).get("apiUrl");
                String userId = robots.get(currentRobot).get("userId");
                String apiKey = robots.get(currentRobot).get("apiKey");
                String content = createJson(message,apiKey,userId);
                String str= HttpRequest.sendPost(apiUrl, content);
                answer = parseAnswer(str);
            }
            if(answer==null || answer.equals("")){
                answer = askSoulRobot("robot",message).getText();
            }

            // 后处理
            reply = handle_answer(answer);
            if (reply==null || reply.getText().equals("")){
                reply = randomReply();
            }

            //Log.i("soulapp_robot","【机器人"+currentRobot+"】" + apiKey.substring(0,4) + "【问题】"+message+"，【回答】" + answer);
        } catch (Exception e) {
            //Log.e("soulapp",e.getLocalizedMessage());
            e.printStackTrace();
        }

        return reply;
    }

    /**
     * 调用组合机器人接口
     * @param message
     * @return
     */
    public ChatReply askSoulRobot(String uid, String message){
        ChatReply reply=new ChatReply();
        String str= null;
        try {
            str = HttpRequest.sendGet(this.robotCallback,"question="+URLEncoder.encode(message,"UTF-8")
            +"&uid="+uid);
            try{
                JSONObject jsonObject = JSONObject.parseObject(str);
                if(jsonObject!=null){
                    reply.setUid(jsonObject.getString("uid"));
                    reply.setText(jsonObject.getString("data"));
                    reply.setType(jsonObject.getString("type"));
                }
            }catch (Exception e){
                System.out.println("响应字符串无法解析为JSON");
                System.out.println(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  reply;
    }

    /**
     * 返回赞赏码回复
     * @return
     */
    public ChatReply getRewardReply(String uid){
        ChatReply reply=new ChatReply();
        reply.setUid(uid);
        reply.setText(this.rewardUrl);
        reply.setType("img");
        return reply;

    }
    public static void main(String[] args)  {
        ChatRobot robot = new ChatRobot();
        for(int i=0; i<20; i++){
            System.out.println(robot.ask("测试"+ i));
        }

//        System.out.println(robot.askSoulRobot("你是谁呀"));

//        try {
//            System.out.println("加解密测试");
//            String key = "123!@#zaqXSWqwer";//密钥
//            String ecpt = "dTVSTWlCOXBxWEhWVlgvZUh1NEExdz09";
//            System.out.println("Ecpt:" + ecpt);
//            String encryptText = DESTest.ecpt2Base64(ecpt);
//            System.out.println("toBase64:" + encryptText);
//            String decryptText = null;
//            decryptText = DESTest.decryptDES(encryptText, key);
//            System.out.println("DES 解密:" + decryptText);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        String receiveMsg = "txt:\"不准哈\"";
//        String regEx = "txt:\"(.*?)\"";
//        Pattern pattern = Pattern.compile(regEx);
//        Matcher matcher = pattern.matcher(receiveMsg);
//        if(matcher.find()){
//            receiveMsg = matcher.group(1);
//            System.out.println(receiveMsg);
//        }else{
//            System.out.println("匹配失败：" + receiveMsg);
//        }
        // 语音识别测试
//        AipClient client = AipClient.getInstance();
//        String result = client.parseVoice("C:\\Users\\arcka\\Desktop\\回复语\\soulrobot\\2.wav");
//        System.out.println(result);

    }

}
