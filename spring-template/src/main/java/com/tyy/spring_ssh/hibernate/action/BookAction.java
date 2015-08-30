package com.tyy.spring_ssh.hibernate.action;

import java.util.List;


import com.opensymphony.xwork2.ActionSupport;
import com.tyy.spring_ssh.hibernate.domain.Book;
import com.tyy.spring_ssh.hibernate.service.BookService;


@SuppressWarnings("serial")
public class BookAction extends ActionSupport
{
	private BookService bookService;
	public void setBookService(BookService bookService)
	{
		this.bookService = bookService;
	}
	
	private Book book;
	private List<Book> books;
	private int id;
	public Book getBook()
	{
		return book;
	}
	public void setBook(Book book)
	{
		this.book = book;
	}
	
	public List<Book> getBooks()
	{
		return books;
	}
	public void setBooks(List<Book> books)
	{
		this.books = books;
	}
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	
	
	public String add()
	{
		// 调用业务逻辑组件的addBook()方法来处理用户请求		
		int result = bookService.addBook(book);
		if(result > 0)
		{
			addActionMessage("恭喜您，图书添加成功！");
			return SUCCESS;
		}
		addActionError("图书添加失败，请重新输入！");
		return ERROR;
	}
	
	public String list()
	{
		setBooks(bookService.getAllBooks());
		return SUCCESS;
	}
	
	public String delete()
	{
		bookService.deleteBook(id);
		return SUCCESS;
	}	
}
