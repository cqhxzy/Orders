package com.hxzy.mapper;

import com.hxzy.entity.User;

public interface UserMapper {

	public int add(User user);
	public User findById(Integer id);
	
	public int update(User user);
}
