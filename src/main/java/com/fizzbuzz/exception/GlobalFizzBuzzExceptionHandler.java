package com.fizzbuzz.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalFizzBuzzExceptionHandler {

	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR, reason="Number upper limit is invalid!!!")
	@ExceptionHandler(InvalidNumberException.class)
	public void handleInvalidNumberException (HttpServletRequest request, HttpServletResponse response, Exception ex) throws Exception {
		response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Number upper limit is invalid!!!");
	}
}
