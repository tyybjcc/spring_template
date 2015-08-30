package com.tyy.spring_ssh.hibernate.service.impl;

import java.util.List;

import com.tyy.spring_ssh.hibernate.dao.BookDao;
import com.tyy.spring_ssh.hibernate.domain.Book;
import com.tyy.spring_ssh.hibernate.service.BookService;


public class BookServiceImpl implements BookService
{
	private BookDao bookDao;
	
	public void setBookDao(BookDao bookDao)
	{
		this.bookDao = bookDao;
	}

	public int addBook(Book book)
	{
		return (Integer) bookDao.save(book);
	}

	public List<Book> getAllBooks()
	{
		return bookDao.findAll(Book.class);
	}

	public void deleteBook(int id)
	{
		bookDao.delete(Book.class, id);
	}
}
