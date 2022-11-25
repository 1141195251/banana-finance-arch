package com.jluzh.msm;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentPBEConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class test1 {
    @Resource
    StringEncryptor encryptor;

    @Test
    public void encryptor(){
        String username = encryptor.encrypt("admin");
        System.out.println(username);

        String password = encryptor.encrypt("feiliuzhixia3qianchi");
        System.out.println(password);
    }
}
