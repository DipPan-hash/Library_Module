package com.module.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.module.library.entities.Books;

public interface BookRepository extends JpaRepository<Books, Long> {

	void deleteByBookId(Long bookId);

}
