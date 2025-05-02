package com.iorta.sboot.service;

import java.util.List;

import com.iorta.sboot.dto.BookDTO;

public interface BookService {
	String createBook(BookDTO bookDTO);
	
	List<BookDTO> getAllBooks();
	
	BookDTO getBookById(Long id);
	
	String updateBook(Long id, BookDTO bookDTO);
	
	String deleteBook(Long id);
}
