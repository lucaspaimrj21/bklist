package com.lucaspaim.bklist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lucaspaim.bklist.dto.BookDTO;
import com.lucaspaim.bklist.dto.BookMinDTO;
import com.lucaspaim.bklist.entities.Book;
import com.lucaspaim.bklist.repositories.BookRepository;



@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Transactional(readOnly = true)
	public BookDTO findById(Long id) {
		Book result = bookRepository.findById(id).get();
		BookDTO dto = new BookDTO(result);
		return dto;
	}
	
	@Transactional(readOnly = true)
	public List<BookMinDTO> findAll() {
		List<Book> result = bookRepository.findAll();
		List<BookMinDTO> dto = result.stream().map(x -> new BookMinDTO(x)).toList();
		return dto;
	}

}
