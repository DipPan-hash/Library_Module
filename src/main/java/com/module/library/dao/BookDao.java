package com.module.library.dao;

import java.util.List;

import com.module.library.entities.Book;

public interface BookDao {

	List<Book> fetchAll();

	Book fetch(Long bookId);

	void addBooks(List<Book> list);

	void updateBookName(Book map);

	void deleteBook(Long bookId);

	void updateAuthors(Book map);
}
