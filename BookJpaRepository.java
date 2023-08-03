package com.glearning.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.glearning.lms.model.Book;

@Repository
public interface BookJpaRepository extends JpaRepository<Book, Long>{

}
