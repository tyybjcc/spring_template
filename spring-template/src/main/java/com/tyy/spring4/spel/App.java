package com.tyy.spring4.spel;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.support.StaticApplicationContext;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonFormat.Value;

public class App {
	
	static void out(String title) {
		System.out.println("\n> "+title+":");
		System.out.println("-----------------");
	}
	
	public static int getRandom() {
		return (int)(Math.random()*100);
	}
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		class Person {
			public int id;
			public String name;
			Person(int id, String name) {
				this.id = id;
				this.name = name;
			}
		}
		
		
		
		ExpressionParser parser = new SpelExpressionParser();
		
		//0. 基础知识
		/*
		 字符串 'str' or "str"
		允许 int.class 等语句
		变量 #var 
		 */
		
		// 1. 简单常量（整形，浮点型，布尔值，字符串）
		out("basic types");
		Expression expre = parser.parseExpression("'HelloWorld'");
		System.out.println( expre.getValue(String.class) );
		expre = parser.parseExpression("2.3F");
		System.out.println( expre.getValue(Float.class) );
		
		
		//数组
		out("array");
		expre = parser.parseExpression("new String[]{'a','aaa'}");
		System.out.println( expre.getValue(String[].class) );
		expre = parser.parseExpression("new int[2][3]");
		System.out.println( expre.getValue() );
		
		//list:{ele1,ele2}
		out("list");
		expre = parser.parseExpression("{1,2,3}");
		System.out.println( expre.getValue() );
		expre = parser.parseExpression(" { {1,2},{1,'a',\"AB\"} } ");
		System.out.println( expre.getValue() );
		{
			//打印list
			List list = expre.getValue(List.class);
			List list2= (List) list.get(1);
			System.out.println("show list:");
			for(Object obj:list2) {
				System.out.print(obj+"("+obj.getClass()+")"+" ");
			}
			System.out.println();
		}
		
		
		//访问数组、list、map
		out("access list,array,map");
		List<String> list = new ArrayList<String>(5);
		list.add("C++");
		list.add("Java");
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(2, "b");
		map.put(4, "d");
		int[] array = {5,7,9};
		//Object[] array2 = {list,array,3.32};	//java数组可以通过文本方式创建了！
		EvaluationContext ctx = new StandardEvaluationContext();
		ctx.setVariable("list", list);
		ctx.setVariable("map", map);
		ctx.setVariable("array", array);
		System.out.println(parser.parseExpression("#list[1]").getValue(ctx));
		System.out.println(parser.parseExpression("#array[1]").getValue(ctx));
		System.out.println(parser.parseExpression("#map[4]").getValue(ctx));
		
		
		//构造对象
		out("construct a new object");
		System.out.println( parser.parseExpression(" new String('abc').substring(1) ").getValue() );
		
		//调用方法
		out("invoke method");
		ctx.setVariable("var1", "abc");
		System.out.println(parser.parseExpression("#var1.toUpperCase()").getValue(ctx));
		System.out.println(parser.parseExpression("'def'.toUpperCase()").getValue());
		
		
		//类 和 静态方法 的调用
		out("class and static method invoking");
		System.out.println( parser.parseExpression("T(Math).random()").getValue() );
		
		//自定义函数
		out("self defined function");
		StandardEvaluationContext ctx2 = (StandardEvaluationContext) ctx;
		ctx2.registerFunction("rdm", App.class.getDeclaredMethod("getRandom", new Class[]{}));
		System.out.println(parser.parseExpression("#rdm()").getValue(ctx));	//自定义函数要用#
		
		
		//算数、比较、逻辑、赋值、三目
		/*
		 和java比较：
		 一致，除了：
		1. 逻辑运算使用 and or not 而不是&& || !
		2. 增加groovy Elvis Expression: 
		 */
		out("logical operation:");
		System.out.println( parser.parseExpression("true and (true or false)").getValue() );
		System.out.println( parser.parseExpression("not true or (true and false)").getValue() );
		out("groovy Elvis Expression");
		System.out.println( parser.parseExpression("null?:'default value'").getValue() );
		System.out.println( parser.parseExpression("false?:'default value'").getValue() );	//false
		
		
		//getters and fields
		/**
		 .运算符不仅可以取属性，还可以调用对应getter方法
		  优先使用getters，fields或getters必须是public修饰
		 */
		out(". operator");
		expre = parser.parseExpression("'Scott'.bytes.length");
		System.out.println( expre.getValue() );
		
		//safe navigation operator
		out("safe navigation operator");
		class A {
			public B b;
			class B {
				public String c;
			}
		}
		A a = new A();
		ctx.setVariable("a", a);
		System.out.println( parser.parseExpression("#a?.b?.c").getValue(ctx) );
		//System.out.println( parser.parseExpression("#a.b.c").getValue(ctx) );	//SpelEvaluationException
		a.b = a.new B();
		a.b.c="ccc";
		System.out.println( parser.parseExpression("#a?.b?.c").getValue(ctx) );
		
		
		//集合选择： collection.?[condition_expr]
		//集合投影： collection.![operation_expr]
		//复杂一点的例子
		out("collection filter and projection");
		Person p1 = new Person(1,"Scott");
		Person p2 = new Person(2,"Alice");
		Map<Integer, Object> map2 = new HashMap<Integer, Object>();
		map2.put(1, p1);
		map2.put(2, p2);
		ctx.setVariable("map2", map2);
		ArrayList result = parser.parseExpression("#map2.?[key>1].![value.name+'*']").getValue(ctx,ArrayList.class);
		System.out.println(result);
		
		
		//template
		out("template");
		System.out.println( parser.parseExpression(" 这个人的ID是#{id},姓名是#{name} ", new TemplateParserContext()).getValue(p1) );
		
		
		
		
		
		
	}
	
	
}
