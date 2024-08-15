package com.ezen.springrest.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@GetMapping(value = "/test", produces = MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public String test() {
		return "주소대신 응답";
	}
}
