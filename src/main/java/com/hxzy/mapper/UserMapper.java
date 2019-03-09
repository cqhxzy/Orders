package com.hxzy.mapper;

import java.util.List;

import com.github.pagehelper.Page;
import com.hxzy.entity.User;
import com.hxzy.vo.IPageDto;
import com.hxzy.vo.PageParamDTO;

public interface UserMapper {

	public int add(User user);
	public User findById(Integer id);
	
	public int update(User user);
	
	public int addBatch(List<User> list);
	
	public int addBatchSQL(List<User> list);
	
	/**
	 * 分页查询
	 * @param pageNum 当前页码
	 * @return
	 */
	public Page<User> selectAll(PageParamDTO<?> dto);
	
	public Page<User> selectAll2(IPageDto dto);
}
