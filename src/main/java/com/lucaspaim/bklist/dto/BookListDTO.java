package com.lucaspaim.bklist.dto;

import com.lucaspaim.bklist.entities.BookList;

public class BookListDTO {
	
	private Long id;
	private String name;
	
	public BookListDTO() {
		
	}

	public BookListDTO(BookList entity) {
		id = entity.getId();
		name = entity.getName();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	
	
	

}
