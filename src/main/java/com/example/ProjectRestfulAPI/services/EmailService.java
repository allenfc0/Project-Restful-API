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
			
			helper.setTo(email.getTo());
			helper.setText(email.getBody());
			helper.setSubject(email.getSubject());
			helper.setFrom(email.getFrom());
			
			sender.send(message);
			
			return true;
		} catch(Exception e) {
			System.out.println(e.getStackTrace());
		}
		return false;
	}
}
