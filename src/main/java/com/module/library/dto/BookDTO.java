package com.module.library.dto;

import java.util.List;

import lombok.Data;

@Data
public class BookDTO {

	private Long id;

	private Long bookId;

	private String bookName;

	private List<AuthorDTO> authors;
}
