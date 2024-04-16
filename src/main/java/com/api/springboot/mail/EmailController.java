package com.api.springboot.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.springboot.dto.ProductDTO;

@RestController
@RequestMapping("/email")
public class EmailController {

	@Autowired
	private EmailService emailService;
	
	@PostMapping
	public String sendMeil(@RequestBody EmailMessage emailMessage)
	{
		String authNum = emailService.sendMail(emailMessage);
		return authNum;
	}
	
	@GetMapping
	public String testing()
	{
		return "[get] email test";
	}
}
