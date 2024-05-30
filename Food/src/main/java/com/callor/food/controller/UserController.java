package com.callor.food.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.food.models.FoodUserVO;
import com.callor.food.models.UserVO;
import com.callor.food.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/user")
public class UserController {
	
	private final UserService userService;
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value="/join",method=RequestMethod.GET)
	public String join() {
		return null;
	}
	
	@RequestMapping(value="/join",method=RequestMethod.POST)
	public String join(@ModelAttribute UserVO userVO, @RequestParam("f_foodname") String fCode) {
		System.out.println("join test");
		UserVO ret = userService.createUser(userVO);
		
		// FoodUserVO 객체 생성 및 필드 설정
	    FoodUserVO foodUserVO = new FoodUserVO();
	    foodUserVO.setF_fcode(fCode);
	    foodUserVO.setF_fuserid(ret.getM_id());
	    FoodUserVO ret2 = userService.createFoodUser(foodUserVO);
		return "redirect:/user/login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login() {
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value="/idcheck/{m_id}")
	public String idcheck(@PathVariable("m_id") String m_id) {
		UserVO userVO = userService.findById(m_id);
		log.debug("fgfvbgfgfgdfgfgfgf{}",m_id);
		if(userVO == null) return "OK";
		return null;
	}

}
