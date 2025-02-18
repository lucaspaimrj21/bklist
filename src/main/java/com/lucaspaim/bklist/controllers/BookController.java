package com.lucaspaim.bklist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucaspaim.bklist.dto.BookDTO;
import com.lucaspaim.bklist.dto.BookMinDTO;
import com.lucaspaim.bklist.services.BookService;

@RestController
@RequestMapping(value = "/books")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping(value = "/{id}")
	public BookDTO findById(@PathVariable Long id) {
		BookDTO result = bookService.findById(id);
		return result;
	}
	
	@GetMapping
	public List<BookMinDTO> findAll() {
		List<BookMinDTO> result = bookService.findAll();
		return result;
	}
	


}
