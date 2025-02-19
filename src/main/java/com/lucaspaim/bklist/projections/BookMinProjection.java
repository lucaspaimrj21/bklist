package com.lucaspaim.bklist.projections;

public interface BookMinProjection {
	
	Long getId();
	String getTitle();
	String getPublisher();
	String getAuthor();
	Integer getPosition();
	
	
}
