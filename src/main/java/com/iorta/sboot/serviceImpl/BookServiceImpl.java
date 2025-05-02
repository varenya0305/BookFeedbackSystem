package com.iorta.sboot.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iorta.sboot.dao.Book;
import com.iorta.sboot.dto.BookDTO;
import com.iorta.sboot.repository.BookRepository;
import com.iorta.sboot.service.BookService;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public String createBook(BookDTO bookDTO) {
		Book book = modelMapper.map(bookDTO, Book.class);
		bookRepository.save(book);
		return "Book created successfully!";
	}

	@Override
	public List<BookDTO> getAllBooks() {
		return bookRepository.findAll()
					  .stream()
					  .map(book -> modelMapper.map(book, BookDTO.class))
					  .collect(Collectors.toList());
	}

	@Override
	public BookDTO getBookById(Long id) {
		Optional<Book> book = bookRepository.findById(id);
		return book.map(b -> modelMapper.map(b, BookDTO.class)).orElse(null);
	}

	@Override
	public String updateBook(Long id, BookDTO bookDTO) {
		Optional<Book> book = bookRepository.findById(id);
		if (book.isPresent()) {
			Book b = book.get();
			b.setTitle(bookDTO.getTitle());
			b.setAuthor(bookDTO.getAuthor());
			b.setDescription(bookDTO.getDescription());
			bookRepository.save(b);
			return "Book updated successfully";
		} 
		return "Book not found!";
	}

	@Override
	public String deleteBook(Long id) {
		bookRepository.deleteById(id);
		return "Book deleted successfully!";
	}
}
