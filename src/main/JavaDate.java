package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class JavaDate {
	public java.sql.Date convert(String giorno, String mese, String anno) {
		

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date1=null;
		try {
			date1 = sdf.parse(anno+"-"+mese+"-"+giorno);
		}catch(ParseException e) {
			e.printStackTrace();
		}
		
		//		String dataStr = sdf.format(date1);
		//		System.out.println(dataStr);
		
		java.sql.Date sqlDate = new java.sql.Date(date1.getTime()); 
		return sqlDate;
		
	}
}
