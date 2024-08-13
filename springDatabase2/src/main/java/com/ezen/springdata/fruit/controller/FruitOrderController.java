package com.ezen.springdata.fruit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ezen.springdata.fruit.service.FruitOrderService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Controller
public class FruitOrderController {
	
	private final FruitOrderService fruitOrderService;
	
	@GetMapping("/fruitorder/list")
	public String list(Model model) {
		model.addAttribute("fruitOrders", fruitOrderService.list());
		model.addAttribute("fruitPurchaseList", fruitOrderService.getPurchaseList());
		return "fruitorder/list";
	}
	
	@PostMapping("/fruitorder/sale")
	public String sale(@RequestParam("fid") Integer fid, @RequestParam("qty") Integer qty) {
		fruitOrderService.saleFruit(fid, qty);
		return "redirect:/fruitorder/list";
	}
	
}
