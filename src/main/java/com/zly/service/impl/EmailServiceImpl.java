package com.zly.service.impl;

import com.zly.service.EmailService;
import com.zly.utils.TemplatesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zly11 on 2018/6/10.
 */
@Service
public class EmailServiceImpl implements EmailService{


    //发送邮件的用户名
    @Value("${spring.mail.username}")
    private String sender;

    //模板引擎对象
    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private JavaMailSender javaMailSender;

    /**
     *
     * @param activationUrl 激活url
     * @param Addressee 收件人用户名
     */
    @Override
    public void sendEmail(String activationUrl,String Addressee) {
        //消息处理类
        MimeMessage message = javaMailSender.createMimeMessage();

        /**
         *      dataMap 用于存储模板渲染所需要的数据
         *      用法和model 一致
         *      dataMap 的 key 对应模板中渲染数据的命名
         */
        Map<String,String> dataMap = new HashMap<>();
        dataMap.put("title","用户名激活");
        dataMap.put("url",activationUrl);

        //获取生成的模板
        String emailText = TemplatesUtil.createTemplates(dataMap,"emailTemplates.html",templateEngine);
        try {
            //消息处理助手对象
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            //设置发件人
            helper.setFrom(sender);

            //设置收件人
            helper.setTo(Addressee);

            //设置邮件标题
            helper.setSubject("主题：用户名激活");

            //设置邮件内容 ，true 表示发送html 格式
            helper.setText(emailText, true);

        } catch (MessagingException e) {
            throw new RuntimeException("Messaging  Exception !", e);
        }
        javaMailSender.send(message);
    }
}
