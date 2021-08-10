package com.PaketDebug;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PaketDebug {

	private static Logger logger = LogManager.getLogger();
	
	
	public static void main(String[] args) {

		for(int i = 1 ; i<=10;i++)
		{
			logger.fatal(i+". Debug Log Çalıştı.");	
		}
		
	}
	
}
