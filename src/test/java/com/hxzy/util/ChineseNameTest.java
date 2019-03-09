package com.hxzy.util;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.hxzy.entity.User;
import com.hxzy.mapper.UserMapper;
import com.hxzy.mapper.impl.UserMapperImpl;

public class ChineseNameTest {

	@Test
	public void testGetChinese() throws IOException {
		List<User> list = new ArrayList<>();
		
		for (int i = 0; i < 100; i++) {
			String name = ChineseName.getFullName();
			String sex = ((int)(Math.random() * 2)) % 2 == 0 ? "男" : "女";
			User user = new User(0,name,null,sex,null);
			list.add(user);
		}
		UserMapper mapper = new UserMapperImpl();
		mapper.addBatch(list);
		
	}
	@Test
	public void testGetChinese2() throws IOException {
		List<User> list = new ArrayList<>();
		
		for (int i = 0; i < 100; i++) {
			String name = ChineseName.getFullName();
			String sex = ((int)(Math.random() * 2)) % 2 == 0 ? "男" : "女";
			User user = new User(0,name,null,sex,null);
			list.add(user);
		}
		UserMapper mapper = new UserMapperImpl();
		mapper.addBatchSQL(list);
		
	}

}
