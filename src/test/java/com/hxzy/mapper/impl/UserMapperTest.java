package com.hxzy.mapper.impl;


import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;

import org.apache.ibatis.cache.Cache;
import org.apache.ibatis.cache.decorators.SynchronizedCache;
import org.apache.ibatis.cache.impl.PerpetualCache;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Ignore;
import org.junit.Test;

import com.hxzy.entity.User;
import com.hxzy.mapper.UserMapper;
import com.hxzy.util.SqlSessionFactoryInstance;


public class UserMapperTest {

	@Test
	@Ignore
	public void testFindById() throws IOException {
		SqlSessionFactory factory = SqlSessionFactoryInstance.getInstance().getSqlSessionFactory();
		
		//第一次sqlSession的回话
		SqlSession session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user1 = mapper.findById(1);
		User user2 = mapper.findById(1);
		System.out.println(user1);
		System.out.println(user2);
		/*
		 	关闭sqlSession的回话
			清空一级缓存中的数据
			将数据写入二级缓存
		*/
		session.close();
		
		//第二次sqlSession的回话
		session = factory.openSession(); 
		mapper = session.getMapper(UserMapper.class);
		User user3 = mapper.findById(1);
		System.out.println(user3);
		session.close();
	}

	@Test
	public void testCache() throws IOException {
		SqlSessionFactory factory = SqlSessionFactoryInstance.getInstance().getSqlSessionFactory();
		//第一次sqlSession的回话
		SqlSession session1 = factory.openSession();
		Object user1 = session1.selectOne("com.hxzy.mapper.UserMapper.findById", 1);
		System.out.println(user1);
		session1.close();
		
		/*SqlSession session2 = factory.openSession();
		
		User user2 = session2.selectOne("com.hxzy.mapper.UserMapper.findById", 1);
		System.out.println(user2);
		user2.setUserName("张三凤");
		session2.update("com.hxzy.mapper.UserMapper.update",user2);
		session2.commit();
		session2.close();
		*/
		
		SqlSession session3 = factory.openSession();
		Object user3 = session3.selectOne("com.hxzy.mapper.UserMapper.findById", 1);
		System.err.println(user3);
		session3.close();
		
	}
	
}
