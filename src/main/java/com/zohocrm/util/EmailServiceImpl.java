package com.zohocrm.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component // now it become the controller layer , @Component convert that to special springBoot class
		   // @Component means springBoot manage the class everything u take care off
public class EmailServiceImpl implements EmailService {


    @Autowired
    private JavaMailSender javaMailSender; // copied from GeeksforGeeks
	
	@Override
	public void sendEmail(String to, String sub, String msg) {
		
		// Creating a simple mail message , copied from GeeksforGeeks
        SimpleMailMessage mailMessage= new SimpleMailMessage();
        
        mailMessage.setTo(to);
        mailMessage.setSubject(sub);
        mailMessage.setText(msg);
        
        // now send the email in this way
        javaMailSender.send(mailMessage); // this is like clicking the mail/send  button
	}

}
