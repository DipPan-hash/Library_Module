package com.module.library.service;

import java.util.List;

import com.module.library.dto.AuthorsDTO;
import com.module.library.dto.BooksDTO;

public interface BookService {

	List<BooksDTO> fetchAll();

	BooksDTO fetch(Long bookId);

	void addBooks(List<BooksDTO> booksDTO);

	void updateBookName(Long bookId, String bookName);

	void deleteBook(Long bookId);

	void updateAuthors(Long bookId, List<AuthorsDTO> authors);

}
