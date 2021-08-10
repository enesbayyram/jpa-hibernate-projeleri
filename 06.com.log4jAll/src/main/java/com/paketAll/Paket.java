package com.paketAll;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Paket {

	public static void main(String[] args) {

		Logger logger = LogManager.getLogger();
		
		for(int i = 1; i<=50; i++)
		{
			logger.fatal(i+". Loglamaya Yapıldı.");	
		}
		
	}

}
