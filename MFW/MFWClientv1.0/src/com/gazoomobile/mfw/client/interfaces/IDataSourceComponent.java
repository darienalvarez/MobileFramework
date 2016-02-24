package com.gazoomobile.mfw.client.interfaces;

public interface IDataSourceComponent {
    public void clearDataSource();
    public void addDataSource(String id, String value, boolean selected);
}
