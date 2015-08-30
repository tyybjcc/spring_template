package com.tyy.spring_ssh.jpa.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.tyy.spring_ssh.jpa.domain.Book;
import com.tyy.spring_ssh.jpa.service.BookService;

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
		System.out.println(bookService.getClass());
		System.out.println(book.getName()+"-----------------------Action");
		bookService.addBook(book);
		int result = book.getId();
		if(result > 0)
		{
			addActionMessage("添加成功！");
			return SUCCESS;
		}
		addActionError("添加失败！");
		return ERROR;
	}
	public String list()
	{
		setBooks(bookService.getAllBooks());
		return SUCCESS;
	}
	public String delete()
	{
		System.out.println(bookService.getClass());	
		bookService.deleteBook(id);
		return SUCCESS;
	}	
}
