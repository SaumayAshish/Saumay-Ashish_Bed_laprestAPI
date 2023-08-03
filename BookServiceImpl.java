package com.glearning.lms.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glearning.lms.model.Book;
import com.glearning.lms.repository.BookJpaRepository;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookJpaRepository bookJpaRepository;

	@Override
	public Book saveBook(Book book) {
		return this.bookJpaRepository.save(book);
	}

	@Override
	public Set<Book> fetchAll() {
		return Set.copyOf(this.bookJpaRepository.findAll());
	}

	@Override
	public Book findBookById(long id) {
		return this.bookJpaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("invalid book id"));
	}

	@Override
	public Book updateBookById(long bookId, Book book) {
		Book bookFromRepository = this.findBookById(bookId);
		bookFromRepository.setAuthor(book.getAuthor());
		bookFromRepository.setName(book.getName());
		bookFromRepository.setCategory(book.getCategory());
		return this.bookJpaRepository.save(bookFromRepository);
	}

	@Override
	public void deleteBookById(long bookId) {
		this.bookJpaRepository.deleteById(bookId);

	}

}
