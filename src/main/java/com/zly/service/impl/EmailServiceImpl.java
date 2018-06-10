package com.zly.service.impl;

import com.zly.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created by zly11 on 2018/6/10.
 */
@Service
public class EmailServiceImpl implements EmailService{


    @Value("${spring.mail.username}")
    private String sender;

    private String recipient = "13112415228@sina.cn";

    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendEmail(String activationUrl,String emailUrl) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(sender);
            helper.setTo(emailUrl);
            helper.setSubject("主题：HTML邮件");
            StringBuffer sb = new StringBuffer();
            sb.append("<a href='"+activationUrl+"'>"+activationUrl+"</a>");

            helper.setText(sb.toString(), true);
        } catch (MessagingException e) {
            throw new RuntimeException("Messaging  Exception !", e);
        }
        javaMailSender.send(message);
    }
}
