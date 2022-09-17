package com.module.library.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.module.library.dao.BookDao;
import com.module.library.dto.AuthorsDTO;
import com.module.library.dto.BooksDTO;
import com.module.library.entities.Books;
import com.module.library.util.ApplicationUtil;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;

	private Logger logger = Logger.getLogger(BookServiceImpl.class.getName());

	@Override
	public List<BooksDTO> fetchAll() {
		try {
			List<Books> books = bookDao.fetchAll();
			return ApplicationUtil.mapAll(books, BooksDTO.class);
		} catch (Exception e) {
			logger.log(Level.SEVERE, () -> "Error fetching all the books :: " + e.getMessage());
			throw e;
		}
	}

	@Override
	public BooksDTO fetch(Long bookId) {
		try {
			Books book = bookDao.fetch(bookId);
			return ApplicationUtil.map(book, BooksDTO.class);
		} catch (Exception e) {
			logger.log(Level.SEVERE, () -> "Error fetching book by Id:: " + e.getMessage());
			throw e;
		}
	}

	@Override
	public void addBooks(List<BooksDTO> booksDTO) {
		try {
			bookDao.addBooks(ApplicationUtil.mapAll(booksDTO, Books.class));
		} catch (Exception e) {
			logger.log(Level.SEVERE, () -> "Error adding new books :: " + e.getMessage());
			throw e;
		}
	}

	@Override
	public void updateBookName(Long bookId, String bookName) {
		try {
			BooksDTO bookDTO = fetch(bookId);
			bookDTO.setBookName(bookName);
			bookDao.updateBookName(ApplicationUtil.map(bookDTO, Books.class));
		} catch (Exception e) {
			logger.log(Level.SEVERE, () -> "Error updating book name :: " + e.getMessage());
			throw e;
		}

	}

	@Override
	public void deleteBook(Long bookId) {
		try {
			bookDao.deleteBook(bookId);
		} catch (Exception e) {
			logger.log(Level.SEVERE, () -> "Error deleting book :: " + e.getMessage());
			throw e;
		}

	}

	@Override
	public void updateAuthors(Long bookId, List<AuthorsDTO> authors) {
		try {
			BooksDTO bookDTO = fetch(bookId);
			bookDTO.setAuthors(authors);
			bookDao.updateAuthors(ApplicationUtil.map(bookDTO, Books.class));
		} catch (Exception e) {
			logger.log(Level.SEVERE, () -> "Error updating authors  :: " + e.getMessage());
			throw e;
		}

	}
}
