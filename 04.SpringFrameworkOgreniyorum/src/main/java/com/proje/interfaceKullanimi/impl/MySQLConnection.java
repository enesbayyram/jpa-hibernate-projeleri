package com.proje.interfaceKullanimi.impl;

import com.proje.interfaceKullanimi.IDBConnection;

public class MySQLConnection implements IDBConnection {

	@Override
	public void openConnection() {
		System.out.println("MYSQL connection bağlantısı açıldı.");
	}

	@Override
	public void closeConnection() {
		System.out.println("MYSQL bağlantısı kapatıldı.");
	}

}
