package com.module.library.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.module.library.constants.ErrorCode;
import com.module.library.constants.ErrorMessage;
import com.module.library.dao.BookDao;
import com.module.library.dto.AuthorDTO;
import com.module.library.dto.BookDTO;
import com.module.library.entities.Book;
import com.module.library.exception.RequestValidationError;
import com.module.library.util.ApplicationUtil;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;

	private Logger logger = Logger.getLogger(BookServiceImpl.class.getName());

	@Override
	public List<BookDTO> fetchAll() {
		try {
			List<Book> books = bookDao.fetchAll();
			return ApplicationUtil.mapAll(books, BookDTO.class);
		} catch (Exception e) {
			logger.log(Level.SEVERE, () -> ErrorMessage.FETCH_ALL_BOOKS_ERR + " :: " + e.getMessage());
			throw new RequestValidationError(ErrorCode.REQUEST_VALIDATION_ERROR, ErrorMessage.FETCH_ALL_BOOKS_ERR);
		}
	}

	@Override
	public BookDTO fetch(Long bookId) {
		try {
			Book book = bookDao.fetch(bookId);
			return ApplicationUtil.map(book, BookDTO.class);
		} catch (Exception e) {
			logger.log(Level.SEVERE, () -> ErrorMessage.FETCH_BOOK_BY_ID_ERR + " :: " + e.getMessage());
			throw new RequestValidationError(ErrorCode.REQUEST_VALIDATION_ERROR, ErrorMessage.FETCH_BOOK_BY_ID_ERR);
		}
	}

	@Override
	public void addBooks(List<BookDTO> booksDTO) {
		try {
			bookDao.addBooks(ApplicationUtil.mapAll(booksDTO, Book.class));
		} catch (Exception e) {
			logger.log(Level.SEVERE, () -> ErrorMessage.ADD_NEW_BOOK_ERR + " :: " + e.getMessage());
			throw new RequestValidationError(ErrorCode.REQUEST_VALIDATION_ERROR, ErrorMessage.ADD_NEW_BOOK_ERR);
		}
	}

	@Override
	public void updateBookName(Long bookId, String bookName) {
		try {
			BookDTO bookDTO = fetch(bookId);
			bookDTO.setBookName(bookName);
			bookDao.updateBookName(ApplicationUtil.map(bookDTO, Book.class));
		} catch (Exception e) {
			logger.log(Level.SEVERE, () -> ErrorMessage.UPDATE_BOOK_NAME_ERR + " :: " + e.getMessage());
			throw new RequestValidationError(ErrorCode.REQUEST_VALIDATION_ERROR, ErrorMessage.UPDATE_BOOK_NAME_ERR);
		}

	}

	@Override
	public void deleteBook(Long bookId) {
		try {
			bookDao.deleteBook(bookId);
		} catch (Exception e) {
			logger.log(Level.SEVERE, () -> ErrorMessage.DELETE_BOOK_ERR + " :: " + e.getMessage());
			throw new RequestValidationError(ErrorCode.REQUEST_VALIDATION_ERROR, ErrorMessage.DELETE_BOOK_ERR);
		}

	}

	@Override
	public void updateAuthors(Long bookId, List<AuthorDTO> authors) {
		try {
			BookDTO bookDTO = fetch(bookId);
			bookDTO.setAuthors(authors);
			bookDao.updateAuthors(ApplicationUtil.map(bookDTO, Book.class));
		} catch (Exception e) {
			logger.log(Level.SEVERE, () -> ErrorMessage.UPDATE_AUTHORS_ERR + " :: " + e.getMessage());
			throw new RequestValidationError(ErrorCode.REQUEST_VALIDATION_ERROR, ErrorMessage.UPDATE_AUTHORS_ERR);
		}

	}
}
