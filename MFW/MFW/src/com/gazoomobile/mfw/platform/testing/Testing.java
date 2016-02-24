package com.gazoomobile.mfw.platform.testing;

import com.gazoomobile.mfw.platform.dao.impl.ApplicationDaoImpl;

public class Testing {
	
	public static void main(String[] args) {
		ApplicationDaoImpl dao = new ApplicationDaoImpl();
		dao.getAll();
	}
}