package com.tyy.spring4.tag;

public class TV implements Product {
	String name = "TV";
	int price;
	Company company;
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
		return "Product "+name+": price("+price+"),company("+getCompany().getName()+")";
	}
	
	
	

}
