package com.example.demo;

import cn.hutool.extra.mail.MailUtil;

public class MailTest {
    public static void main(String[] args) {
        String messageId = MailUtil.send("*@qq.com", "测试", "我是内容", false);
        System.out.println(messageId);
    }
}
