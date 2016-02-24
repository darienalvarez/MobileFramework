package com.gazoomobile.mfw.client.interfaces;

import java.util.List;

public interface IDataSource {
    public void setDataSource(String command, List<String> outputFields);
}
