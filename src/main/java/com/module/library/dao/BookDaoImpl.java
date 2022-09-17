package com.module.library.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.module.library.entities.Books;
import com.module.library.repository.BookRepository;

@Repository
public class BookDaoImpl implements BookDao {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<Books> fetchAll() {
		return bookRepository.findAll(Sort.by("name"));
	}

	@Override
	public Books fetch(Long bookId) {
		Optional<Books> findById = bookRepository.findById(bookId);
		return findById.isPresent() ? findById.get() : null;
	}

	@Override
	public void addBooks(List<Books> books) {
		bookRepository.saveAll(books);

	}

	@Override
	public void updateBookName(Books book) {
		bookRepository.save(book);

	}

	@Override
	public void deleteBook(Long bookId) {
		bookRepository.deleteByBookId(bookId);

	}

	@Override
	public void updateAuthors(Books book) {
		bookRepository.save(book);
	}

}
