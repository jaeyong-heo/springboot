package com.api.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.springboot.dto.MemberDto;





@RestController
public class MainController {

	private final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	private String version = "0.0.0" ;
	
	@GetMapping("/")
	public String main()
	{
		logger.info("main access");
		return "Is running...";
	}
	
	@PutMapping("/put")
	public ResponseEntity<MemberDto> putTest(@RequestBody MemberDto memberDto)
	{
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(memberDto);
	}
	
	
}
