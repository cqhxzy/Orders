package com.hxzy.mapper.impl;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Ignore;
import org.junit.Test;

import com.github.pagehelper.IPage;
import com.github.pagehelper.Page;
import com.hxzy.entity.User;
import com.hxzy.mapper.UserMapper;
import com.hxzy.vo.IPageDto;
import com.hxzy.vo.PageParamDTO;

public class UserMapperImplTest {

	@Test
	@Ignore
	public void testInsert() throws IOException {
		UserMapper mapper = new UserMapperImpl();
		User user = new User();
		user.setUserName("翠花");
		user.setSex("女");
		int insert = mapper.add(user);
		assertEquals(1, insert);
	}

	@Test
	public void testFindById() throws IOException {
		UserMapper mapper = new UserMapperImpl();
		User user = mapper.findById(2);
		System.out.println(user);
	}
	
	@Test
	public void testSelectAll() throws IOException {
		UserMapper mapper = new UserMapperImpl();
		PageParamDTO<?> dto = new PageParamDTO<>(12,10);
		Page<User> page = mapper.selectAll(dto);
		long total = page.getTotal(); //总共有多少条数据
		System.out.println("总共" + total + "条数据");
		System.out.println("总页数：" + page.getPages());
		for (User user : page) {
			System.out.println(user);
		}
	}
	
	@Test
	public void testSelectAll2() throws IOException {
		UserMapper mapper = new UserMapperImpl();
		IPageDto dto = new IPageDto(1,5);
		dto.setParams("张");
		Page<User> page = mapper.selectAll2(dto);
		long total = page.getTotal(); //总共有多少条数据
		System.out.println("总共" + total + "条数据");
		System.out.println("总页数：" + page.getPages());
		for (User user : page) {
			System.out.println(user);
		}
	}
}
