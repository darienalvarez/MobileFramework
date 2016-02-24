package com.gazoomobile.mfw.platform.exception;

public class MfwException extends Exception {
	private static final long serialVersionUID = 2718610429039094435L;

	public MfwException() {
		super();
	}

	public MfwException(String message, Throwable cause) {
		super(message, cause);
	}

	public MfwException(String message) {
		super(message);
	}

	public MfwException(Throwable cause) {
		super(cause);
	}
}