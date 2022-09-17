package com.module.library.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ErrorResponseDTO {

	private String message;

	private String error;

	private Integer code;

	private Date timestamp;

}
