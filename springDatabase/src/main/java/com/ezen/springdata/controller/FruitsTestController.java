package com.ezen.springdata.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ezen.springdata.dto.FruitDTO;
import com.ezen.springdata.mapper.FruitsRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/fruit")
@RequiredArgsConstructor
@Controller
public class FruitsTestController {
	
	private final FruitsRepository fruitsRepository;
	
	@GetMapping("/add")
	public String addFruitForm() {
		return "fruit/add_form";
	}
	
	@PostMapping("/add")
	public String addFruit(FruitDTO fruit) {
		log.info("{}", fruit);
		
		log.info("insert 결과 : {}", fruitsRepository.add(fruit));
		
		return "redirect:/fruit/add";
	}
}
