package com.module.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.module.library.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

	void deleteByBookId(Long bookId);

}
