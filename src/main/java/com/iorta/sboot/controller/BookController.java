package com.iorta.sboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iorta.sboot.dto.BookDTO;
import com.iorta.sboot.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@PostMapping("/createBook")
	public String createBook(@RequestBody BookDTO bookDTO) {
		return bookService.createBook(bookDTO);
	}
	
	@GetMapping("/getAllBooks")
	public List<BookDTO> getAllBooks() {
		return bookService.getAllBooks();
	}
	
	@GetMapping("/getBookById/{id}")
	public BookDTO getBookById(@PathVariable Long id) {
		return bookService.getBookById(id);
	}
	
	@PutMapping("/updateBook/{id}")
	public String updateBook(@PathVariable Long id, @RequestBody BookDTO bookDTO) {
		return bookService.updateBook(id, bookDTO);
	}
	
	@DeleteMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable Long id) {
		return bookService.deleteBook(id);
	}
}
