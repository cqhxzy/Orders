package com.hxzy.mapper.impl;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.hxzy.entity.User;
import com.hxzy.mapper.UserMapper;
import com.hxzy.util.SqlSessionFactoryInstance;

public class UserMapperImpl implements UserMapper{
	
	private SqlSessionFactory factory;

	public UserMapperImpl() throws IOException {
		factory = SqlSessionFactoryInstance.getInstance().getSqlSessionFactory();
	}

	@Override
	public int add(User user) {
		SqlSession session = factory.openSession();
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			int insert = mapper.add(user);
			session.commit();
			return insert;
		} catch (Exception e) {
			//实际工作中，异常信息是需要通过日志文件记录并保存。
			e.printStackTrace();
		} finally {
			session.close();
		}
		return 0;
	}

	@Override
	public User findById(Integer id) {
		SqlSession session = factory.openSession();
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			return mapper.findById(id);
		} catch (Exception e) {
			//实际工作中，异常信息是需要通过日志文件记录并保存。
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public int update(User user) {
		
		return 0;
	}

}
