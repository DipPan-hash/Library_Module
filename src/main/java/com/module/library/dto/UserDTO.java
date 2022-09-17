package com.module.library.dto;

import lombok.Data;

@Data
public class UserDTO {

	private Long id;

	private String role;

	private String email;

	private String password;
}
