package com.callor.food.service;

import com.callor.food.models.FoodVO;
import com.callor.food.models.UserVO;

public interface UserService {
	
	public UserVO createUser(UserVO createUserVO);
	public UserVO findById(String m_id);
	
	public FoodVO selectAll();
	

}
