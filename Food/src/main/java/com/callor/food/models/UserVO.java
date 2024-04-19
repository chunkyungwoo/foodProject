package com.callor.food.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserVO {
	
	private String m_id;
	private String m_password;
	private String m_email;
	private String m_name;
	private String m_role;
	private String m_tel;
}
