package com.itshidu.web.test;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

public class TestMail {
	public static void main(String[] args) throws MessagingException {
		
		JavaMailSenderImpl sender = new JavaMailSenderImpl();
		sender.setPort(25);
		sender.setHost("smtp.163.com");
		sender.setUsername("wushuangcat@163.com");
		sender.setPassword("gogogo");

		//使用JavaMail的MimeMessage，支付更加复杂的邮件格式和内容
	    MimeMessage msg = sender.createMimeMessage();

	    //创建MimeMessageHelper对象，处理MimeMessage的辅助类
	    MimeMessageHelper helper = new MimeMessageHelper(msg, true);

	    //使用辅助类MimeMessage设定参数
	    helper.setFrom(sender.getUsername());
	    helper.setTo("1500506007@qq.com");
	    helper.setSubject("恭喜您获得千万大奖");
	    helper.setText("<font color=red>恭喜您获得千万大奖6666666666</font>",true);
	    
	    sender.send(msg);
		
	}
}
