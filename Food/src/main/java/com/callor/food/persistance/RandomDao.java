package com.callor.food.persistance;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.callor.food.models.FoodVO;

public interface RandomDao {
	
	@Select("SELECT * FROM tbl_food")
	public List<FoodVO> selectAll();
	
	public FoodVO findById(String f_code);

}
