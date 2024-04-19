package com.callor.food.persistance;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.callor.food.models.RoleVO;

public interface RoleDao {
	
	public int insertAll(List<RoleVO> roles);
	
	@Select("SELECT * FROM tbl_role WHERE r_mid = #{m_id}")
	public List<RoleVO> findByUserName(String username);

}
