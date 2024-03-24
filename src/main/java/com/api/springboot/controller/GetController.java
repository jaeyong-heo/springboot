package com.api.springboot.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {

	private final Logger logger = LoggerFactory.getLogger(GetController.class);
	
	// http://localhost:8080/api/v1/get-api/hello
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String getHello()
	{
		logger.info("메서드 호출 : getHello()");
		return "hello world";
	}
	
	@GetMapping(value = "/name")
	public String getName()
	{
		return "Flature";
	}
	
	@GetMapping(value = "/variable1/{variable}")
	public String getVariable1(@PathVariable String variable)
	{
		return variable;
	}
	
	@GetMapping(value = "/variable2/{variable}")
	public String getVariable2(@PathVariable("variable") String var)
	{
		return var;
	}
	
	@GetMapping(value = "/request1")
	public String getRequestParam1(
			@RequestParam String name,
			@RequestParam String email,
			@RequestParam String organization) {
		return name + " " + email + " " + organization;
	}
	
	@GetMapping("/request2")
	public String getRequestParam2(@RequestParam Map<String, String> param) {
		StringBuilder sb = new StringBuilder();
		
		param.entrySet().forEach(map -> {
			sb.append(map.getKey() + " : " + map.getValue() + "\n");
		});
		
		return sb.toString();
	}
	
	
	
}
