package com.email.model;

public class EmailRequest{
	private String to;
	private String message;
	private String subject;
	
	
	public EmailRequest() {
		super();
	}
	public EmailRequest(String to, String message, String subject) {
		super();
		this.to = to;
		this.message = message;
		this.subject = subject;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	@Override
	public String toString() {
		return "EmailRequest [to=" + to + ", message=" + message + ", subject=" + subject + "]";
	}
	
	
}
