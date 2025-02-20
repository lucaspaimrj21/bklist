package com.lucaspaim.bklist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucaspaim.bklist.dto.BookListDTO;
import com.lucaspaim.bklist.dto.BookMinDTO;
import com.lucaspaim.bklist.dto.ReplacementDTO;
import com.lucaspaim.bklist.services.BookListService;
import com.lucaspaim.bklist.services.BookService;

@RestController
@RequestMapping(value = "/lists")
public class BookListController {
	
	@Autowired
	private BookListService bookListService;
	
	@Autowired
	private BookService bookService;
	
	@GetMapping
	public List<BookListDTO> findAll() {
		List<BookListDTO> result = bookListService.findAll();
		return result;
	}
	
	@GetMapping(value = "/{listId}/books")
	public List<BookMinDTO> findByList(@PathVariable Long listId) {
		List<BookMinDTO> result = bookService.findbyList(listId);
		return result;
	}
	
	@PostMapping(value = "/{listId}/replacement")
	public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body) {
		bookListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
		
	}
	


}
