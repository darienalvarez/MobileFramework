package com.gazoomobile.mfw.platform.exception;

public class MfwRuntimeException extends RuntimeException {
	private static final long serialVersionUID = -8014595184484255055L;

	public MfwRuntimeException() {
		super();
	}

	public MfwRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public MfwRuntimeException(String message) {
		super(message);
	}

	public MfwRuntimeException(Throwable cause) {
		super(cause); 
	}
}