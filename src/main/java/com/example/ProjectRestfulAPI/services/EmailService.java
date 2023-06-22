package com.example.ProjectRestfulAPI.services;

import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.ProjectRestfulAPI.models.Email;

import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
	
	@Autowired
	private JavaMailSender sender;
	
	
	
	// Using the JMS API - JMS Client
	// JMS Provider - Send Email/JMS Sender
	public boolean sendEmail(Email email) {
		MimeMessage message = sender.createMimeMessage();
		
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, 
					MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
			email.setTo("allentestemail536@gmail.com");
			
			// Can't set from 
			//helper.setFrom(email.getFrom());
			helper.setTo(email.getTo());
			helper.setSubject(email.getSubject());
			helper.setText(String.format("Hello Allen,\nMy name is %s.\n%s\nSent From: %s", email.getFromName(), email.getBody(), email.getFrom()));
			
			sender.send(message);
			
			return true;
		} catch(Exception e) {
			System.out.println(e.getCause());
		}
		return false;
	}
}
