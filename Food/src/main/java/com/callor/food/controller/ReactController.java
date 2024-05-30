package com.callor.food.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.callor.food.models.FoodVO;
import com.callor.food.service.RandomService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value="/react")
public class ReactController {
	private final RandomService randomService;
	
	public ReactController(RandomService randomService){
		this.randomService = randomService;
	}
	
	@GetMapping("/getCategory/{f_sort}")
	public List<FoodVO> getCategory(@PathVariable("f_sort") String f_sort){
		List<FoodVO> foodVO = randomService.findById(f_sort);
		if(foodVO == null) {
			
		}
		return foodVO;
	}

}
