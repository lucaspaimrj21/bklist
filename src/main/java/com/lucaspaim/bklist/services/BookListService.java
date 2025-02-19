package com.lucaspaim.bklist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lucaspaim.bklist.dto.BookListDTO;
import com.lucaspaim.bklist.entities.BookList;
import com.lucaspaim.bklist.repositories.BookListRepository;

@Service
public class BookListService {
	
	@Autowired
	private BookListRepository bookListRepository;
	
	@Transactional(readOnly = true)
	public List<BookListDTO> findAll() {
		List<BookList> result = bookListRepository.findAll();
		List<BookListDTO> dto = result.stream().map(x -> new BookListDTO(x)).toList();
		return dto;
	}

}
