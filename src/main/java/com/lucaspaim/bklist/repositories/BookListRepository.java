package com.lucaspaim.bklist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucaspaim.bklist.entities.BookList;

public interface BookListRepository extends JpaRepository<BookList, Long> {

}
