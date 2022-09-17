package com.module.library.dao;

import java.util.List;

import com.module.library.entities.Books;

public interface BookDao {

	List<Books> fetchAll();

	Books fetch(Long bookId);

	void addBooks(List<Books> list);

	void updateBookName(Books map);

	void deleteBook(Long bookId);

	void updateAuthors(Books map);
}
