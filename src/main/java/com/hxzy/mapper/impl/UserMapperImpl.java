package com.hxzy.mapper.impl;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.github.pagehelper.IPage;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hxzy.entity.User;
import com.hxzy.mapper.UserMapper;
import com.hxzy.util.SqlSessionFactoryInstance;
import com.hxzy.vo.IPageDto;
import com.hxzy.vo.PageParamDTO;

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

	@Override
	public int addBatch(List<User> list) {
		//通过mybatis批处理插入数据
		SqlSession session = factory.openSession(ExecutorType.BATCH);
		try {
			for (User user : list) {
				session.insert("com.hxzy.mapper.UserMapper.add", user);
			}
			session.commit();
			return 1;
		} catch (Exception e) {
			session.rollback();
			//实际工作中，异常信息是需要通过日志文件记录并保存。
			e.printStackTrace();
		} finally {
			session.close();
		}
		return 0;
	}

	@Override
	public int addBatchSQL(List<User> list) {
		/*
			通过mysql进行批处理插入数据
		 *  insert int tab(column1,column2..) values (?,?,...),(?,?,...),(?,?,...),(?,?,...)
		 * 
		 * */
		SqlSession session = factory.openSession();
		try {
			session.insert("com.hxzy.mapper.UserMapper.addBatch", list);
			
			session.commit();
			return 1;
		} catch (Exception e) {
			session.rollback();
			//实际工作中，异常信息是需要通过日志文件记录并保存。
			e.printStackTrace();
		} finally {
			session.close();
		}
		return 0;
	}

	@Override
	public Page<User> selectAll(PageParamDTO<?> dto) {
		SqlSession session = factory.openSession();
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			
			//通过PageHelper设置了查询起始后，立即执行mapper代理查询，否则有可能出现bug
			PageHelper.startPage(dto.getPageNum(),dto.getPageSize());
			Page<User> page = mapper.selectAll(dto);
			return page;
			
		} catch (Exception e) {
			//实际工作中，异常信息是需要通过日志文件记录并保存。
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public Page<User> selectAll2(IPageDto dto) {
		SqlSession session = factory.openSession();
		try {
			UserMapper mapper = session.getMapper(UserMapper.class);
			
			//通过PageHelper设置了查询起始后，立即执行mapper代理查询，否则有可能出现bug
			PageHelper.startPage(dto);
			Page<User> page = mapper.selectAll2(dto);
			return page;
			
		} catch (Exception e) {
			//实际工作中，异常信息是需要通过日志文件记录并保存。
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

}
