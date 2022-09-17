package com.module.library.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.module.library.entities.Book;
import com.module.library.repository.BookRepository;

@Repository
public class BookDaoImpl implements BookDao {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<Book> fetchAll() {
		return bookRepository.findAll(Sort.by("name"));
	}

	@Override
	public Book fetch(Long bookId) {
		Optional<Book> findById = bookRepository.findById(bookId);
		return findById.isPresent() ? findById.get() : null;
	}

	@Override
	public void addBooks(List<Book> books) {
		bookRepository.saveAll(books);

	}

	@Override
	public void updateBookName(Book book) {
		bookRepository.save(book);

	}

	@Override
	public void deleteBook(Long bookId) {
		bookRepository.deleteByBookId(bookId);

	}

	@Override
	public void updateAuthors(Book book) {
		bookRepository.save(book);
	}

}
