package com.callor.food.service;

import com.callor.food.models.FoodVO;

public interface RandomService {
	
	public FoodVO random(String f_foodname);
	
	public FoodVO findById(String f_sort);

}
