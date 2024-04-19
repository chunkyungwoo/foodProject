package com.callor.food.service.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.callor.food.models.RoleVO;
import com.callor.food.models.UserVO;
import com.callor.food.persistance.RoleDao;
import com.callor.food.persistance.UserDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("authProviderImpl")
public class AuthProviderImpl implements AuthenticationProvider{
	
	private final PasswordEncoder passwordEncoder;
	private final UserDao userDao;
	private final RoleDao roleDao;
	public AuthProviderImpl(@Qualifier("passEncoderV1") PasswordEncoder passwordEncoder, UserDao userDao, RoleDao roleDao) {
		// TODO Auto-generated constructor stub
		this.passwordEncoder = passwordEncoder;
		this.userDao = userDao;
		this.roleDao = roleDao;
	}
	

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		String m_id= authentication.getName();
		String m_password = authentication.getCredentials().toString();
		
		UserVO userVO = userDao.findById(m_id);
		if(userVO == null) {
			throw new UsernameNotFoundException(String.format("id확인 : %s는 없음", m_id));
		}
		boolean passOK = passwordEncoder.matches(m_password,userVO.getM_password());
		if(!passOK) {
			throw new BadCredentialsException("비밀번호 오류");
		}
		List<RoleVO> roles = roleDao.findByUserName(m_id);
		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		
		for(RoleVO r : roles) {
			grantList.add(new SimpleGrantedAuthority(r.getR_role()));
		}
		Authentication token = new UsernamePasswordAuthenticationToken(userVO, m_password,grantList);
		return token;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}

}
