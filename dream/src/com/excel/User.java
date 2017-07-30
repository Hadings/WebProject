package com.excel;

public class User {
	private String name;
	private int age;
	private String year;
	private String phone;
	
	public User(String name, int age, String year, String phone) {
		super();
		this.name = name;
		this.age = age;
		this.year = year;
		this.phone = phone;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}