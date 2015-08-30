package com.tyy.spring.autowire.by_type;

public class Master implements IMaster{
	ISlave slave;

	public ISlave getSlave() {
		return slave;
	}

	public void setSlave(ISlave slave) {
		this.slave = slave;
	}
	
}
