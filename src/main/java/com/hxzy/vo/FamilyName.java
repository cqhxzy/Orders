package com.hxzy.vo;

public class FamilyName {
	//姓
	private String name;
	//姓的权重，权重越大，随机生成姓名时概率越大
	private int weigth;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWeigth() {
		return weigth;
	}
	public void setWeigth(int weigth) {
		this.weigth = weigth;
	}
	public FamilyName(String name, int weigth) {
		super();
		this.name = name;
		this.weigth = weigth;
	}
	@Override
	public String toString() {
		return "FamilyName [name=" + name + ", weigth=" + weigth + "]";
	}
	
	
}
