package com.code.utils;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoggerUtility {

	public static final DateFormat format=new SimpleDateFormat("MM/dd/yyyy kk:mm:ss");
	public static final String strDefLoggerLocation="c:/easy_logger/projects";	;
	public static String generateTimestamp(String strName){
		return format.format(new Date())+": "+strName;
	}
	
	public static boolean isValidProperty(String str){
		return str==null||str.isEmpty();
	}
	
	public static String getProjectName(){
		String[] arr=new File("").getAbsolutePath().split("\\\\");
		return (arr.length>0)?arr[arr.length-1]:getDummyProjectName();
	}
	
	private static String getDummyProjectName(){
		File f=null;
		String str=null;
		for(int i=1;;i++){
			String strName="Project"+i;
			f=new File(strDefLoggerLocation,strName);
			if(!f.exists()){
				str=strName;
				break;
			}
		}
		return str;
	}
}
