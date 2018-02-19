package main;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Clock {

	
	private static SimpleDateFormat timeFormatter = new SimpleDateFormat("kk:mm:ss");
	private static SimpleDateFormat dateFormatter = new SimpleDateFormat("dd.MM.yyyy");
	
	public static String date() {
		return dateFormatter.format(new Date());
	}
	
	public static String time() {
		return dateFormatter.format(new Date());
	}
	
	
}
