package com.lld.problems.SnakeNLadders;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TimeDiff {

	public static void main(String[] args) {

		String s1 = "Sun 10 May 2015 13:54:36 -0700";
		String s2 = "Sun 10 May 2015 13:54:36 -0000";
		String d1 = "Sat 02 May 2015 19:54:36 +0530";
		
		String d2 = "Fri 01 May 2015 13:54:36 -0000";
		
		
		String arr1 [] =  s1.split(" ");
		
		
		String arr2 [] =  s2.split(" ");
		
		
		
		/*
		 * Date date = new Date(s1); DateFormat df = new
		 * SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z"); df.format(date);
		 * System.out.println(date);
		 * 
		 * Date date2 = new Date(s2); df.format(date2); System.out.println(date2);
		 * 
		 * 
		 * System.out.println(date.getTime() - date2.getTime());
		 */
		  
		 
		
		
			
		

		  Date date = new Date(d1); 
		  DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
		  df.format(date);
		  System.out.println(date);
		  
		  Date date2 = new Date(d2); 
		  df.format(date2);
		  System.out.println(date2);
		  
		  
		  System.out.println(date.getTime() - date2.getTime());
		

	}
}
