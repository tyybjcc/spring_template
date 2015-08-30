package com.tyy.spring.iop;

public class Converter1 implements ConverterInter {

	public String convert(String input) {
		return "Converter1: "+input.toLowerCase();
	}

}
