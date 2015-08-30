package com.tyy.spring.iop;

public class Converter2 implements ConverterInter {

	public String convert(String input) {
		return "Converter2: "+input.toUpperCase();
	}

}
