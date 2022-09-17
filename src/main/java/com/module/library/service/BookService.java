package com.module.library.service;

import java.util.List;

import com.module.library.dto.AuthorDTO;
import com.module.library.dto.BookDTO;

public interface BookService {

	List<BookDTO> fetchAll();

	BookDTO fetch(Long bookId);

	void addBooks(List<BookDTO> booksDTO);

	void updateBookName(Long bookId, String bookName);

	void deleteBook(Long bookId);

	void updateAuthors(Long bookId, List<AuthorDTO> authors);

}
