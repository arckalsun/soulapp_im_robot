package com.arckal.soul.web;

import com.arckal.soul.service.ChatService;
import com.arckal.soul.utils.DESTest;
import com.arckal.soul.utils.Ecpt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: arckal
 * @Date: 2019/1/3 13:52
 * @Version 1.0
 */
@RestController
public class EncryptController {

    private final String key = "123!@#zaqXSWqwer";



    /**
     * 解密
     * @param text
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/decrypt")
    public String decrypt(String text,HttpServletRequest request, HttpServletResponse response) throws Exception {
        if(!StringUtils.isEmpty(text)){
            String encryptText = DESTest.ecpt2Base64(text);
            String decryptText = DESTest.decryptDES(encryptText, key);
            return decryptText;
        }else{
            return "text is null!";
        }
    }

    /**
     * 加密
     * @param text
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/encrypt")
    public String encrypt(String text,HttpServletRequest request, HttpServletResponse response) throws Exception {
        if(!StringUtils.isEmpty(text)){
            String encryptText = DESTest.encryptDES(text, key);
            String ecpt = Ecpt.toEcpt(encryptText);
            return ecpt;
        }else{
            return "text is null!";
        }
    }


}
