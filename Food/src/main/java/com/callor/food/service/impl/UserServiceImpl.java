package com.callor.food.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.callor.food.models.FoodVO;
import com.callor.food.models.RoleVO;
import com.callor.food.models.UserVO;
import com.callor.food.persistance.RoleDao;
import com.callor.food.persistance.UserDao;
import com.callor.food.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	private final PasswordEncoder passwordEncoder;
	private final UserDao userDao;
	private final RoleDao roleDao;
	public UserServiceImpl(@Qualifier("passEncoderV1") PasswordEncoder passwordEncoder, UserDao userDao, RoleDao roleDao) {
		super();
		this.passwordEncoder = passwordEncoder;
		this.userDao = userDao;
		this.roleDao = roleDao;
		
	}
	

	@Override
	@Transactional
	public UserVO createUser(UserVO createUserVO) {
		// TODO Auto-generated method stub
		String m_id = createUserVO.getM_id();
		String m_password = createUserVO.getM_password();
		
		List<UserVO> userList = userDao.selectAll();
		
		// password 암호화
		String encPassword = passwordEncoder.encode(m_password);
		createUserVO.setM_password(encPassword);
		
		List<RoleVO> roles = new ArrayList<>();
		if(userList == null || userList.size() <= 0) {
			roles.add(RoleVO.builder().r_mid(m_id).r_role("ROLE_ADMIN").build());
			roles.add(RoleVO.builder().r_mid(m_id).r_role("ROLE_USER").build());
		}else {
			roles.add(RoleVO.builder().r_mid(m_id).r_role("ROLE_USER").build());
		}
		userDao.insert(createUserVO);
		roleDao.insertAll(roles);
		return null;
	}
	
	@Autowired
	public void create_table() {
		userDao.create_user_table(null);
		userDao.create_role_table(null);
	}

	@Override
	public UserVO findById(String m_id) {
		// TODO Auto-generated method stub
		return userDao.findById(m_id);
	}


	@Override
	public FoodVO selectAll() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
