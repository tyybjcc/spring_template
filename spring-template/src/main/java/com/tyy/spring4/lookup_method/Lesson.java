package com.tyy.spring4.lookup_method;

import java.util.Random;

public class Lesson {
	String lesson;
	private static final String[] lessons = new String[]{"Chinese","Math","Physics","English","Art"};
	private static Random random = new Random();
	public Lesson() {
		this.lesson = lessons[random.nextInt(lessons.length)];
	}
	public String getLesson() {
		return lesson;
	}
	
}
