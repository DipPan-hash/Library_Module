package com.module.library.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.module.library.dto.ErrorResponseDTO;

@ControllerAdvice
public class GlobalErrorHandler {

	@ExceptionHandler({ RequestValidationError.class })
	public ResponseEntity<ErrorResponseDTO> handleRequestValidationException(RequestValidationError ex) {
		ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
		errorResponseDTO.setCode(ex.getCode());
		errorResponseDTO.setError("Request Validation Error ");
		errorResponseDTO.setMessage(ex.getMessage());
		errorResponseDTO.setTimestamp(new Date());
		return new ResponseEntity<>(errorResponseDTO, HttpStatus.BAD_REQUEST);
	}
}
