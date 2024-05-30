package com.callor.food.persistance;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.callor.food.models.FoodVO;

public interface FoodDao {
	

	public List<FoodVO> selectAll();

	public List<FoodVO> findById(String f_sort);
	


}
