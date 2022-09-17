package com.module.library.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RequestValidationError extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final Integer code;
	
	private final String message;

}
