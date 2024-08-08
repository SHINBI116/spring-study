package com.ezen.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ezen.springmvc.dto.Practice;


@RequestMapping("/pra")
@Controller
public class PracticeController {
	
	@RequestMapping("p0")
	public String rmp() {
		return "/practice/page0";
	}
	
	@PostMapping("p1")
	public String postMethodName(Practice p, Model model) {
		
		model.addAttribute("p", p);
		
		return "/practice/page1";
	}
	
}
