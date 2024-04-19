package com.callor.food.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public String join(@ModelAttribute UserVO userVO) {
		
		UserVO ret = userService.createUser(userVO);
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
