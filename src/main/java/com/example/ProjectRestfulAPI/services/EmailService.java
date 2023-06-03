package com.example.ProjectRestfulAPI.services;

import org.springframework.stereotype.Service;

import com.example.ProjectRestfulAPI.models.Email;

@Service
public class EmailService {
	
	// I will not be using a DAO - Data Access Object because there is no database = involved
	
	public static String format(Email email) {
		
		//if email sent successfully throw 200 code, else send error code
		
		System.out.println(email);
		return email.toString();
	}
}
