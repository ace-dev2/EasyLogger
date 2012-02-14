package com.code.services;

import java.util.Map;

public class Logger {

	private static Object lock;
	private static Logger logger=null;
	private String strFilename;
	
	private Logger(){
		super();
		lock=this;
	}
	public static Logger getLogger(){
		if(logger==null){
			logger=new Logger();
		}
		return logger;
	}
	public static void log(String message,Map map){
		synchronized(lock){
			
		}
	}
}
