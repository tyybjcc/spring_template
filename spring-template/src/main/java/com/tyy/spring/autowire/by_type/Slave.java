package com.tyy.spring.autowire.by_type;

public class Slave implements ISlave{
	IMaster master;

	public IMaster getMaster() {
		return master;
	}

	public void setMaster(IMaster master) {
		this.master = master;
	}
	

}
