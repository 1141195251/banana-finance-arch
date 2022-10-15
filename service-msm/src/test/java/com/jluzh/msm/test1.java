package com.jluzh.msm;

import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class test1 {
    @Resource
    StringEncryptor encryptor;

    @Test
    public void encryptor(){
//        String username = encryptor.encrypt("");
    }
}
