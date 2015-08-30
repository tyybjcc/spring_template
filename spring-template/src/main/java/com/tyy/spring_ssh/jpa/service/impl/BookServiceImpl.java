package com.tyy.spring_ssh.jpa.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import com.tyy.spring_ssh.jpa.dao.BookDao;
import com.tyy.spring_ssh.jpa.domain.Book;
import com.tyy.spring_ssh.jpa.service.BookService;


@Transactional
public class BookServiceImpl implements BookService
{
	private BookDao bookDao;
	
	public void setBookDao(BookDao bookDao)
	{
		this.bookDao = bookDao;
	}
	public void addBook(Book book)
	{
		System.out.println(book.getName()+"-----------------------Service");
		bookDao.save(book);
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
