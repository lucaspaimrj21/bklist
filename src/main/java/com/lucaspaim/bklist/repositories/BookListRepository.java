package com.lucaspaim.bklist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.lucaspaim.bklist.entities.BookList;

public interface BookListRepository extends JpaRepository<BookList, Long> {
	
	@Modifying
	@Query(nativeQuery = true, 
		value = "UPDATE tb_belonging SET position = :newPosition WHERE list_id = :listId AND book_id = :bookId")
	void updateBelongingPosition(Long listId, Long bookId, Integer newPosition);

}
