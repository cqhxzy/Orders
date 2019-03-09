package com.hxzy.vo;

public class PageParamDTO<T>{
	private int pageNum = 1;
	private int pageSize = 10;
	private T t;//SQL语句执行时需要的参数
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public T getT() {
		return t;
	}
	public void setT(T t) {
		this.t = t;
	}
	public PageParamDTO(int pageNum, int pageSize, T t) {
		super();
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.t = t;
	}
	
	
	public PageParamDTO(int pageNum) {
		super();
		this.pageNum = pageNum;
	}
	
	public PageParamDTO(int pageNum, int pageSize) {
		super();
		this.pageNum = pageNum;
		this.pageSize = pageSize;
	}
	public PageParamDTO() {
		super();
	}

}
