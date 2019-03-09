package com.hxzy.vo;

import com.github.pagehelper.IPage;

public class IPageDto implements IPage {

	/**
	 * 页码
	 */
	private Integer pageNum = 1;
	
	/**
	 * 页面大小
	 */
	private Integer pageSize = 10;
	
	/**
	 * SQL查询需要用到的参数
	 */
	private Object params;

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Object getParams() {
		return params;
	}

	public void setParams(Object params) {
		this.params = params;
	}

	@Override
	public String getOrderBy() {
		// TODO Auto-generated method stub
		return null;
	}

	public IPageDto(Integer pageNum, Integer pageSize, Object params) {
		super();
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.params = params;
	}

	public IPageDto(Integer pageNum, Integer pageSize) {
		super();
		this.pageNum = pageNum;
		this.pageSize = pageSize;
	}

	public IPageDto(Integer pageNum) {
		super();
		this.pageNum = pageNum;
	}

	public IPageDto() {
		super();
	}
	
	

}
