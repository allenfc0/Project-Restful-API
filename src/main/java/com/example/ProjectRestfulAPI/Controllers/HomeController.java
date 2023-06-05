package com.example.ProjectRestfulAPI.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProjectRestfulAPI.models.Email;
import com.example.ProjectRestfulAPI.services.EmailService;

@RestController
@CrossOrigin(origins="*")
public class HomeController {
	
	@Autowired
	private EmailService emailService;
	
	@GetMapping(path={"/", "/api"})
	public String welcome() {
		return "Welcome to this Home API";
	}
	
	
	  @PostMapping(value="/api/send-email") 
	  public ResponseEntity<Email> sendEmail(@RequestBody Email email) { 
		  boolean sent = emailService.sendEmail(email);
		  
		  if(!sent) return new ResponseEntity<Email>(email, HttpStatus.BAD_REQUEST);
		  return new ResponseEntity<Email>(email, HttpStatus.ACCEPTED);
	  }
}
