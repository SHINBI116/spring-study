package com.ezen.springdata.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class RedirectTestController {

	@GetMapping(value = { "/redirect/home", "/redirect/" })
	public String home(Model model) {
		model.addAttribute("포도");
		model.addAttribute(2000);
		model.addAttribute("fruit", "포도");
		model.addAttribute("price", "2000");
		return "redirect/home";
	}

	@GetMapping("/redirect")
	public String home2() {
		return "redirect:/redirect/home";
	}
	@GetMapping("/redirect/home3")
	public String home3() {
		return "redirect/home";
	}
	
	@GetMapping("/redirect/test3")
	public String test3(RedirectAttributes rattr) {
		// 리다이렉트시 한번 사용되고 사라지는 어트리뷰트 (메모리 관리 용이)
		rattr.addFlashAttribute("fruit", "grape");
		rattr.addFlashAttribute("price", "3500");

		return "redirect:/redirect/home3";
	}
}
