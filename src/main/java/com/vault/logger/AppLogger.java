package com.vault.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppLogger
{
	
	public static Logger getInstance(Object object) {

		return LoggerFactory.getLogger(object.getClass());
	}
}
