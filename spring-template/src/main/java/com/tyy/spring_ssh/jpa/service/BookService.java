package com.tyy.spring_ssh.jpa.service;

import java.util.List;

import com.tyy.spring_ssh.jpa.domain.Book;



public interface BookService
{
	void addBook(Book book);

	List<Book> getAllBooks();
	
	void deleteBook(int id);
}
