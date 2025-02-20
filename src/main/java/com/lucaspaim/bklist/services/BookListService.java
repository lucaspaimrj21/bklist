package com.lucaspaim.bklist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lucaspaim.bklist.dto.BookListDTO;
import com.lucaspaim.bklist.entities.BookList;
import com.lucaspaim.bklist.projections.BookMinProjection;
import com.lucaspaim.bklist.repositories.BookListRepository;
import com.lucaspaim.bklist.repositories.BookRepository;

@Service
public class BookListService {
	
	@Autowired
	private BookListRepository bookListRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Transactional(readOnly = true)
	public List<BookListDTO> findAll() {
		List<BookList> result = bookListRepository.findAll();
		List<BookListDTO> dto = result.stream().map(x -> new BookListDTO(x)).toList();
		return dto;
	}
	
	@Transactional
	public void move(Long listId, int sourceIndex, int destinationIndex) {
		List<BookMinProjection> list = bookRepository.searchByList(listId);
		
		BookMinProjection obj = list.remove(sourceIndex);
		list.add(destinationIndex, obj);
		
		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;
		
		for(int i = min; i<= max; i++) {
			bookListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
		}
	}
	

}
