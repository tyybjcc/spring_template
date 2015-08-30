package com.tyy.spring4.tag;

public class Samsung implements Company {
	String name;
	Product[] products;

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Product[] getProducts() {
		return products;
	}


	public void setProducts(Product[] products) {
		this.products = products;
	}


	public String getInfo() {
		if(this.products==null) this.products = new Product[0];
		String rtn = "Company "+this.getName()+" produces "+this.getProducts().length+" products:";
		for(Product p:this.products) {
			rtn+=" "+p.getName();
		}
		return rtn;
	}

}
