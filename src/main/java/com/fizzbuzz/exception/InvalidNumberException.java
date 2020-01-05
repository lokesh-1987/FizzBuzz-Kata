package com.fizzbuzz.exception;

public class InvalidNumberException extends RuntimeException {

	private static final long serialVersionUID = -3265917990958516672L;

	public InvalidNumberException(String message) {
        super(message);
    }
}