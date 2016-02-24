package com.gazoomobile.mfw.client.connector;

public class ConnectorRuntimeException extends RuntimeException {
	private static final long serialVersionUID = -1541547532744468217L;

	public ConnectorRuntimeException() {
		super();
	}

	public ConnectorRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public ConnectorRuntimeException(String message) {
		super(message);
	}

	public ConnectorRuntimeException(Throwable cause) {
		super(cause);
	}
}