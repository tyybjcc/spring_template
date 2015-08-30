package com.tyy.spring4.lookup_method;

public abstract class Student implements StudentInter{
	Lesson lesson;

	public Lesson getLesson() {
		return lesson;
	}

	public abstract void setLesson(Lesson lesson);

	
}
