package com.tyy.spring.iop.autowire;

public class Man {
	AxeInter axe;

	public AxeInter getAxe() {
		return axe;
	}

	public void setAxe(AxeInter axe) {
		this.axe = axe;
	}
	
	public void manChop() {
		this.getAxe().chop();
	}
}
