package com.lucaspaim.bklist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucaspaim.bklist.dto.BookMinDTO;
import com.lucaspaim.bklist.entities.Book;
import com.lucaspaim.bklist.repositories.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	public List<BookMinDTO> findAll() {
		List<Book> result = bookRepository.findAll();
		List<BookMinDTO> dto = result.stream().map(x -> new BookMinDTO(x)).toList();
		return dto;
	}

}
