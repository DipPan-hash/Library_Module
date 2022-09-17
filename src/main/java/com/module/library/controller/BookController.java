package com.module.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.module.library.dto.AuthorDTO;
import com.module.library.dto.BookDTO;
import com.module.library.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;

	// list books sorted by name
	@GetMapping("/users")
	public ResponseEntity<List<BookDTO>> fetchAll() {
		return ResponseEntity.ok(bookService.fetchAll());
	}

	// list one book
	@GetMapping("users/{bookId}")
	public ResponseEntity<BookDTO> fetch(@PathVariable Long bookId) {
		return ResponseEntity.ok(bookService.fetch(bookId));
	}

	// add new book(s)
	@PostMapping("/users")
	public ResponseEntity<HttpStatus> addBooks(@RequestBody List<BookDTO> booksDTO) {
		bookService.addBooks(booksDTO);
		return ResponseEntity.ok(HttpStatus.CREATED);
	}

	// update book name
	@PostMapping("/users")
	public ResponseEntity<HttpStatus> updateBookName(@RequestParam Long bookId, @RequestParam String bookName) {
		bookService.updateBookName(bookId, bookName);
		return ResponseEntity.ok(HttpStatus.OK);
	}

	// update book author’s list
	@PostMapping("/admin")
	public ResponseEntity<HttpStatus> updateAuthors(@RequestParam Long bookId, @RequestParam List<AuthorDTO> authors) {
		bookService.updateAuthors(bookId, authors);
		return ResponseEntity.ok(HttpStatus.OK);
	}

	// delete book
	@DeleteMapping("admin/{bookId}")
	public ResponseEntity<HttpStatus> deleteBook(@PathVariable Long bookId) {
		bookService.deleteBook(bookId);
		return ResponseEntity.ok(HttpStatus.OK);
	}
}
