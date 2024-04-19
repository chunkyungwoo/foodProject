package com.callor.food.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.food.models.FoodVO;
import com.callor.food.persistance.FoodDao;

import lombok.extern.slf4j.Slf4j;

/**
 * Handles requests for the application home page.
 */
@Slf4j
@Controller
public class HomeController {
	private FoodDao foodDao = null;

	
	public HomeController(FoodDao foodDao) {
		super();
		this.foodDao = foodDao;
	}
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		return "home";
	}
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String home() {
		return null;
		
	}
	@ResponseBody
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public List<FoodVO> list() {
		System.out.println("food List ");
		List<FoodVO> foodVO = foodDao.selectAll();
		//System.out.println("food List2 "+foodVO.toString());
		return foodVO;
	}
	
}
