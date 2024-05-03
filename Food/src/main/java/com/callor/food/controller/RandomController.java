package com.callor.food.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.food.models.FoodVO;
import com.callor.food.service.RandomService;

@Controller
@RequestMapping(value="/random")
public class RandomController {
	
	private final RandomService randomService;
	
	
	public RandomController(RandomService randomService) {
		this.randomService = randomService;
	}
	
	private static final List<String> FOOD_LIST = Arrays.asList(
            "Pizza", "Burger", "Sushi", "Pasta", "Salad",
            "Taco", "Sandwich", "Steak", "Ramen", "Fried Chicken"
    );

//	@Autowired
//	private FoodDao foodDao;
	
	@RequestMapping(value={"/",""},method=RequestMethod.GET)
	public String random(Model model) {
		Random random = new Random();
		int randomIndex = random.nextInt(FOOD_LIST.size());
		String randomFood = FOOD_LIST.get(randomIndex);
		model.addAttribute("food",randomFood);
		return "food/random";
	}
	
	@ResponseBody
	@RequestMapping(value="/getCategory/{f_sort}")
	public String getcategory(@PathVariable("f_sort") String f_sort) {
		FoodVO foodVO = randomService.findById(f_sort);
		if(foodVO == null) return "OK";
		return null;
	}

}
