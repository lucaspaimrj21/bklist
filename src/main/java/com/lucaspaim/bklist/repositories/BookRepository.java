package com.lucaspaim.bklist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucaspaim.bklist.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	
	

}
