package com.module.library;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.module.library.dto.AuthorDTO;
import com.module.library.dto.BookDTO;

@SpringBootTest
public class LibraryApplicationTests {

	@Autowired
	private RestTemplate restTemplate;

	@Test
	public void addBooks() {
		AuthorDTO authorDTO = AuthorDTO.builder().authorId(10l).authorName("Dr. Hansraj").build();
		BookDTO bookDTO = BookDTO.builder().bookId(1l).bookName("Organic Chemistry").authors(List.of(authorDTO))
				.build();
		HttpEntity<?> requestEntity = new HttpEntity<>(bookDTO, null);
		ResponseEntity<HttpStatus> responseEntity = restTemplate.exchange("/books/users", HttpMethod.POST,
				requestEntity, HttpStatus.class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

	@Test
	public void fetchAll() {
		ResponseEntity<BookDTO> responseEntity = restTemplate.exchange("/books/users", HttpMethod.GET, null,
				BookDTO.class);
		AuthorDTO authorDTO = AuthorDTO.builder().authorId(10l).authorName("Dr. Hansraj").build();
		assertEquals(List.of(authorDTO), responseEntity.getBody().getAuthors());
	}

	@Test
	public void fetch() {
		ResponseEntity<BookDTO> responseEntity = restTemplate.exchange("/books/users/1l", HttpMethod.GET, null,
				BookDTO.class);
		assertEquals("Organic Chemistry", responseEntity.getBody().getBookName());
	}

	@Test
	public void updateBookName() {
		String url = UriComponentsBuilder.fromHttpUrl("/books/users").queryParam("bookId", 1l)
				.queryParam("bookName", "Physical Chemistry").toUriString();
		ResponseEntity<HttpStatus> postResponseEntity = restTemplate.exchange(url, HttpMethod.POST, null,
				HttpStatus.class);
		assertEquals(HttpStatus.OK, postResponseEntity.getStatusCode());
	}

	@Test
	public void updateAuthors() {
		AuthorDTO authorDTO = AuthorDTO.builder().authorId(11l).authorName("Dr. Hansmukh").build();
		String url = UriComponentsBuilder.fromHttpUrl("/books/admin").queryParam("bookId", 1l)
				.queryParam("authors", List.of(authorDTO)).toUriString();
		ResponseEntity<HttpStatus> postResponseEntity = restTemplate.exchange(url, HttpMethod.POST, null,
				HttpStatus.class);
		assertEquals(HttpStatus.OK, postResponseEntity.getStatusCode());

	}

	@Test
	public void deleteBook() {
		ResponseEntity<HttpStatus> responseEntity = restTemplate.exchange("/books/admin/1l", HttpMethod.DELETE, null,
				HttpStatus.class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

}
