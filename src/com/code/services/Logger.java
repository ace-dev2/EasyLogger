package com.code.services;

import java.io.BufferedWriter;
import java.io.File;
import java.util.Map;
import java.util.ResourceBundle;

import com.code.utils.LoggerUtility;

public class Logger {

	private static Object lock;
	private static Logger logger=null;
	private String strFilename;
	private static final String strConfigFileName="easy_logger.properties";
	private static String strClassName;
	private BufferedWriter writer;
	private BufferedWriter writer2;
	
	private Logger(){
		super();
		//hello comment
		lock=this;
	}
	public static Logger getLogger(){
		if(logger==null){
			logger=new Logger();
		}
		initializeWriter();
		return logger;
	}
	
	private static void initializeWriter(){
		ResourceBundle bundle=ResourceBundle.getBundle(strConfigFileName);
		String strLocation=bundle.getString("location");
		String strProjName=bundle.getString("project_name");
		if(!LoggerUtility.isValidProperty(strLocation)){
			strLocation=LoggerUtility.strDefLoggerLocation;	
		}
		if(!LoggerUtility.isValidProperty(strProjName)){
			strProjName=LoggerUtility.getProjectName();
		}
		File file=new File(strLocation,strProjName);
		file.mkdirs();
	}
	public void log(String message,Map map){
		StringBuffer buf=new StringBuffer(LoggerUtility.generateTimestamp(strClassName));
		synchronized(lock){
			writeToFile(message,map,buf.toString());
		}
	}
	
	private void writeToFile(String message,Map map, String strInfo){
		
	}
}
