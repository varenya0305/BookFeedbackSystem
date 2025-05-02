package com.iorta.sboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iorta.sboot.dao.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
