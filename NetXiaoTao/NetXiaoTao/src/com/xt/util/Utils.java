package com.xt.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
	public static String getCurrentTime(){
		Date currentTime=new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		return dateString;
	}
	
	public static String getCurrentTimeWithoutSpace(){
		Date currentTime=new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateString = formatter.format(currentTime);
		return dateString;
	}
}
