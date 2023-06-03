package com.example.ProjectRestfulAPI.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.ProjectRestfulAPI.models.Email;

@Repository
public class EmailRepository {
	
	private List<Email> localDatabase = new ArrayList<Email>();
	
	public Email save(Email e) {
		Email email = new Email();
		email.setFrom(e.getFrom());
		email.setTo(e.getTo());
		email.setTitle(e.getTitle());
		email.setBody(e.getBody());
		localDatabase.add(email);
		
		return email;
	}
}
