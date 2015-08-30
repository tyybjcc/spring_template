package com.tyy.spring_ssh.hibernate.service;

import java.util.List;

import com.tyy.spring_ssh.hibernate.domain.Book;



public interface BookService
{
	int addBook(Book book);

	List<Book> getAllBooks();
	
	void deleteBook(int id);
}
