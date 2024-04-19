package com.callor.food.persistance;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.callor.food.models.UserVO;

public interface UserDao {
	
	@Select("SELECT * FROM tbl_user ORDER BY m_id")
	public List<UserVO> selectAll();
	
	@Select("SELECT * FROM tbl_user WHERE m_id = #{m_id}")
	public UserVO findById(String m_id);
	
	public int insert(UserVO userVO);
	public int update(UserVO userVO);
	public int delete(String m_id);
	
	public void create_user_table(String dumy);
	public void create_role_table(String dumy);

}
