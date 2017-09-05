package com.huyaoban.caveatemptor.exceptions;

public class PermissionException extends RuntimeException {
	public PermissionException() {}

	public PermissionException(String message) {
		super(message);
	}

	public PermissionException(String message, Throwable cause) {
		super(message, cause);
	}

	public PermissionException(Throwable cause) {
		super(cause);
	}
}
