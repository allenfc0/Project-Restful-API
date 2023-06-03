package com.example.ProjectRestfulAPI.models;


public class Email {
	
	private String from;
	private String to;
	private String title;
	private String body;
	
	public Email() {
		
	}
	
	public Email(String from, String to, String title, String body) {
		this.from = from;
		this.to = to;
		this.title = title;
		this.body = body;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "Email [from=" + from + ", to=" + to + ", title=" + title + ", body=" + body + "]";
	}
	
	
	
	
}
