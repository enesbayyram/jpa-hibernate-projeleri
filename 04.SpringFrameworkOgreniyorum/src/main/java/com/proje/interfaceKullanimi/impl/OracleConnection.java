package com.proje.interfaceKullanimi.impl;

import com.proje.interfaceKullanimi.IDBConnection;

public class OracleConnection implements IDBConnection{

	@Override
	public void openConnection() {
		System.out.println("Oracle bağlantısı açıldı.");
	}

	@Override
	public void closeConnection() {
		System.out.println("Oracle bağlantısı kapatıldı.");
	}

}
