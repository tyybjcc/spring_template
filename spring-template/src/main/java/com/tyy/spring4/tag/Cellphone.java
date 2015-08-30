package com.tyy.spring4.tag;

public class Cellphone implements Product {
	String name = "Cellphone";
	int price;
	Company company;
	
	public Cellphone() {}
	public Cellphone(String name) {
		this.name = name;
	}
	public Cellphone(String name, int price, Company company) {
		super();
		this.name = name;
		this.price = price;
		this.company = company;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public String getInfo() {
		return "Product "+name+": price("+price+"), company("+getCompany().getName()+")";
	}
	
	
	

}
