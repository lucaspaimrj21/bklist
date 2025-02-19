package com.lucaspaim.bklist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lucaspaim.bklist.entities.Book;
import com.lucaspaim.bklist.projections.BookMinProjection;

public interface BookRepository extends JpaRepository<Book, Long> {
	
	@Query(nativeQuery = true, value = """
			SELECT tb_book.id, tb_book.title, tb_book.publisher, tb_book.author, tb_belonging.position
			FROM tb_book
			INNER JOIN tb_belonging ON tb_book.id = tb_belonging.book_id
			WHERE tb_belonging.list_id = :listId
			ORDER BY tb_belonging.position
			""")

	List<BookMinProjection> searchByList(Long listId);
	

}
