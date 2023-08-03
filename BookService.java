package com.glearning.lms.service;

import java.util.Set;

import com.glearning.lms.model.Book;

public interface BookService {
	
	Book saveBook(Book book);
	
	Set<Book> fetchAll();
	
	Book findBookById(long id);
	
	Book updateBookById(long bookId, Book book);
	
	void deleteBookById(long bookId);

}
