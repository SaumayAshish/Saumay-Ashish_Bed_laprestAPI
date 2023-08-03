package com.glearning.lms.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import com.glearning.lms.model.Book;
import com.glearning.lms.model.Role;
import com.glearning.lms.model.User;
import com.glearning.lms.repository.BookJpaRepository;
import com.glearning.lms.repository.UserJpaRepository;

@Configuration
public class BootstrapAppData {
	
	@Autowired
	private UserJpaRepository userJpaRepository;
	
	@Autowired
	private BookJpaRepository bookRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@EventListener(ApplicationReadyEvent.class)
	@Transactional
	public void loadUsers(ApplicationReadyEvent event) {

		// addding users and roles

		User kiran = new User("kiran", this.passwordEncoder.encode("welcome"));
		User vinay = new User("vinay", this.passwordEncoder.encode("welcome"));
		User ramesh = new User("ramesh", this.passwordEncoder.encode("welcome"));

		Role userRole = new Role("ROLE_USER");
		Role adminRole = new Role("ROLE_ADMIN");
		Role superAdminRole = new Role("ROLE_SUPER_ADMIN");

		kiran.addRole(userRole);

		vinay.addRole(userRole);
		vinay.addRole(adminRole);
		
		ramesh.addRole(userRole);
		ramesh.addRole(adminRole);
		ramesh.addRole(superAdminRole);

		this.userJpaRepository.save(kiran);
		this.userJpaRepository.save(vinay);
		this.userJpaRepository.save(ramesh);
	}
	
	@EventListener(ApplicationReadyEvent.class)
	@Transactional
	public void loadBooks(ApplicationReadyEvent event) {

		Book book1 = new Book();
		book1.setName("book-1");
		book1.setAuthor("Raju");
		book1.setCategory("Adventure");

		Book book2 = new Book();
		book2.setName("book-2");
		book2.setAuthor("Rakesh");
		book2.setCategory("Comedy");

		Book book3 = new Book();
		book3.setName("book-3");
		book3.setAuthor("Vinay");
		book3.setCategory("Suspense");

		Book book4 = new Book();
		book4.setName("book-4");
		book4.setAuthor("Harish");
		book4.setCategory("Drama");
		
		this.bookRepository.save(book1);
		this.bookRepository.save(book2);
		this.bookRepository.save(book3);
		this.bookRepository.save(book4);
	}
}
