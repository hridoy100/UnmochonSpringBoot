package com.example.demo.controller;

import com.example.demo.encryption.CryptoException;
import com.example.demo.encryption.CryptoUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@RestController
public class EncryptionController {

    @RequestMapping("/")
    public String getOut(){
        String key = "6874lCJJvHm1C8fiDM";
        String aeskeyStr = Base64.getEncoder().encodeToString(key.getBytes(StandardCharsets.UTF_8));
//        File inputFile = new File("kurama.jpg");
        File encryptedFile = new File("kurama.encrypted");
        File decryptedFile = new File("kuramadecrypted.jpg");

        try {
//            CryptoUtils.encrypt(aeskeyStr, inputFile, encryptedFile);
            CryptoUtils.decrypt(aeskeyStr, encryptedFile, decryptedFile);
        } catch (CryptoException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        return "Hello";
    }
}
