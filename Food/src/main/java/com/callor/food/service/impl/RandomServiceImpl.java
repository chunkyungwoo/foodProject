package com.callor.food.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.food.models.FoodVO;
import com.callor.food.persistance.FoodDao;
import com.callor.food.service.RandomService;

@Service
public class RandomServiceImpl implements RandomService{
	
	private final FoodDao foodDao;
	public RandomServiceImpl(FoodDao foodDao) {
		this.foodDao = foodDao;
	}

	@Override
	public FoodVO random(String f_foodname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FoodVO> findById(String f_sort) {
		// TODO Auto-generated method stub
		return foodDao.findById(f_sort);
	}

}
