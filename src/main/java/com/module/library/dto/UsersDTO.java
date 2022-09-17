package com.module.library.dto;

import com.module.library.constants.Roles;

import lombok.Data;

@Data
public class UsersDTO {

	private Long id;

	private Roles role;
}
