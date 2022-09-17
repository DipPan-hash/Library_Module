package com.module.library.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Data
@Entity
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "author_id")
	private Long authorId;

	@Column(name = "author_name")
	private String authorName;

	@ManyToMany(mappedBy = "authors")
	private List<Book> books;

}
