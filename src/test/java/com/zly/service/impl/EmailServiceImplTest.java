package com.zly.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by zly11 on 2018/6/10.
 */
@RunWith(SpringRunner.class)

public class EmailServiceImplTest {

    @Value("${spring.mail.username}")
    private String sender;


    @Autowired
    private JavaMailSender javaMailSender;


    @Test
    public void sendEmail() throws Exception {

        SimpleMailMessage message = new SimpleMailMessage();

        // 发送者

        message.setFrom(sender);
        // 接收者
        message.setTo("13112415228@sina.cn");
        //邮件主题
        message.setSubject("主题：文本邮件");
        // 邮件内容
        message.setText("骚扰邮件勿回");
        javaMailSender.send(message);

    }

}