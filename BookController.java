package com.glearning.lms.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.glearning.lms.model.Book;
import com.glearning.lms.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping("/list")
	public String listBooks(Model model) {
		Set<Book> books = this.bookService.fetchAll();
		model.addAttribute("books", books);
		return "/books/list-books";
	}
	
	@PostMapping("/save")
	public String saveBook(@ModelAttribute("book") Book book){
		this.bookService.saveBook(book);
		return "redirect:/books/list";
	}
	
	@RequestMapping("/delete")
	public String deleteBookById(@RequestParam("id") long bookId) {
		this.bookService.deleteBookById(bookId);
		return "redirect:/books/list";
	}
	
	@RequestMapping("/form")
	public String showForm(Model model) {
		Book book = new Book();
		model.addAttribute("book", book);
		return "/books/book-form";
	}
	
	@PostMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("id") int id, Model model) {

		// get the book from the service
		Book theBook = bookService.findBookById(id);

		// set book as a model attribute to pre-populate the form
		model.addAttribute("book", theBook);

		return "books/book-form";
	}
		 
}
