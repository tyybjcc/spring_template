package com.tyy.spring4.create_bean.static_factory_method;

import org.aspectj.org.eclipse.jdt.core.dom.ThisExpression;

public class AnimalFactory {
	public static AnimalInter getAnimal(String what) {
		if(what==null || what.length()==0) {
			return null;
		}
		what = what.substring(0,1).toUpperCase()+what.substring(1);
		try {
			String packageName = AnimalFactory.class.getPackage().getName();	//获取当前类所在包 包名
			return (AnimalInter)Class.forName(packageName+"."+what).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
