package com.callor.food.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.food.models.FoodVO;
import com.callor.food.persistance.RandomDao;

@Controller
@RequestMapping(value="/random")
public class RandomController {
	
	private final RandomDao randomDao;
	public RandomController(RandomDao randomDao) {
		this.randomDao = randomDao;
	}
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String random(Model model) {
		List<FoodVO> foodList = randomDao.selectAll();
		model.addAttribute("FOOD_LIST",foodList);
		return "random/home";
	}
	
	@RequestMapping(value="/random/food",method=RequestMethod.POST)
	public String random(FoodVO foodVO) {
		return null;
	}

}
