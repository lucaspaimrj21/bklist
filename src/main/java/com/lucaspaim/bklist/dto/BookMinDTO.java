package com.lucaspaim.bklist.dto;

import com.lucaspaim.bklist.entities.Book;
import com.lucaspaim.bklist.projections.BookMinProjection;

public class BookMinDTO {
	
	private Long id;
	private String title;
	private String publisher;
	private String author;
	
	public BookMinDTO() {
		
	}

	public BookMinDTO(Book entity) {
		id = entity.getId();
		title = entity.getTitle();
		publisher = entity.getPublisher();
		author = entity.getAuthor();
	}
	
	public BookMinDTO(BookMinProjection projection) {
		id = projection.getId();
		title = projection.getTitle();
		publisher = projection.getPublisher();
		author = projection.getAuthor();
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getPublisher() {
		return publisher;
	}

	public String getAuthor() {
		return author;
	}
	
	
}

	
