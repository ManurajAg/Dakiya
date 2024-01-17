package com.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.email.model.EmailRequest;
import com.email.model.EmailResponse;
import com.email.service.EmailService;
import com.sun.mail.iap.Response;

@RestController
@CrossOrigin
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	
	@GetMapping("/")
	public String welcome() {
		return "hello, this is my email api";
	}
	
	@PostMapping("/sendEmail")
	public ResponseEntity<?> sendEmail(@RequestBody EmailRequest email) {
		//this.emailService.sendEmail(null, null, null);
		boolean result = this.emailService.sendEmail(email.getSubject(), email.getMessage(), email.getTo());
		if(result) {
			return ResponseEntity.ok(new EmailResponse("Email Sent"));
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new EmailResponse("Email Not Sent"));
	}
}
