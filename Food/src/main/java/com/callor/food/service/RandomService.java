package com.callor.food.service;

import java.util.List;

import com.callor.food.models.FoodVO;

public interface RandomService {
	
	public FoodVO random(String f_foodname);
	
	public List<FoodVO> findById(String f_sort);

}
