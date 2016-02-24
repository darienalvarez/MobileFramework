package com.gazoomobile.mfw.client.connector;

import java.util.List;

public interface MfwConnector {
	public List<String> getConfigurationProperties();
	
	public Object execute(String query) throws ConnectorException;
}