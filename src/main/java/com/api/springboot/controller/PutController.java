package com.api.springboot.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.springboot.dto.MemberDto;

@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {

	private final Logger logger = LoggerFactory.getLogger(PutController.class);
	
	@PutMapping(value = "/member")
	public String postMember(@RequestBody Map<String, Object> putData)
	{
		StringBuilder sb = new StringBuilder();
		
		putData.entrySet().forEach(map -> {
			sb.append(map.getKey() + " : " + map.getValue());
		});
		
		return sb.toString();
	}
	
	@PutMapping("/member1")
	public String postMemberDto1(@RequestBody MemberDto memberDto)
	{
		return memberDto.toString();
	}
	
	@PutMapping("/member2")
	public MemberDto postMemberDto2(@RequestBody MemberDto memberDto)
	{
		return memberDto;
	}
}
