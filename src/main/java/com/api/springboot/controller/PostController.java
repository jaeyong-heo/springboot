package com.api.springboot.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.springboot.dto.MemberDto;

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {

	private final Logger logger = LoggerFactory.getLogger(PostController.class);
	
	@RequestMapping(value = "/domain", method = RequestMethod.POST)
	public String postExample()
	{
		return "Hello Post API";
	}
	
	@PostMapping(value = "/member")
	public String postMember(@RequestBody Map<String, Object> postData)
	{
		StringBuilder sb = new StringBuilder();
		
		postData.entrySet().forEach(map -> {
			sb.append(map.getKey() + " : " + map.getValue());
		});
		
		return sb.toString();
	}
	
	@PostMapping(value = "/member2")
	public String postMemberDto(@RequestBody MemberDto memberDto)
	{
		return memberDto.toString();
	}
	
	
	
}
