package com.example.ProjectRestfulAPI.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProjectRestfulAPI.models.Email;
import com.example.ProjectRestfulAPI.repositories.EmailRepository;

@Service
public class EmailService {
	
	@Autowired
	private EmailRepository repo;
	
	public Email saveEmail(Email email) {
		return repo.save(email);
	}
	
	public static String format(Email email) {
		
		//if email sent successfully throw 200 code, else send error code
		
		System.out.println(email);
		return email.toString();
	}
}
