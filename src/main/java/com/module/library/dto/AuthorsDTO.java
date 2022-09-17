package com.module.library.dto;

import java.util.List;

import lombok.Data;

@Data
public class AuthorsDTO {

	private Long id;
	
	private Long authorId;
	
	private String authorName;

	private List<BooksDTO> books;

}
