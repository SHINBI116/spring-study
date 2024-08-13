package com.ezen.springdata.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		
		log.info("insert 결과 : {}", fruitsRepository.add2(fruit));
		
		return "redirect:/fruit/add";
	}
	
	// 과일 목록 보기, 과일 삭제하기, 과일 정보 수정하기
	@GetMapping("/getAll")
	public String getAllFruits(Model model) {
		model.addAttribute("fruitsList", fruitsRepository.selectAll());
		
		return "fruit/list";
	}
	
	@GetMapping("/update/{fid}")
	public String getAllFruits(Model model, @PathVariable("fid") Integer fid) {
		model.addAttribute("fruit", fruitsRepository.detail(fid));
		
		return "fruit/detail";
	}
	
	@PostMapping("/update")
	public String update(FruitDTO fruit) {
		log.info("{} : ", fruit);
		log.info("update : {}", fruitsRepository.update(fruit));
		
		return "redirect:/fruit/getAll";
	}
	
	@GetMapping("/delete/{fid}")
	public String delete(@PathVariable("fid") Integer fid) {
		log.info("delete : {}", fruitsRepository.delete(fid));
		
		return "redirect:/fruit/getAll";
	}
	
	
}
