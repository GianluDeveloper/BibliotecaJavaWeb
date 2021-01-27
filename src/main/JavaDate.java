package main;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class JavaDate {
	public String back(java.sql.Date d) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String ret = sdf.format(d);
		return ret;
		//		java.util.Date d1 = new java.util.Date(d.getTime());
		//		return d1;
	}
	public String handleWebFormat(String input) {
		String[] tmp = input.split("-");
		String[] newTmp = new String[tmp.length];
		int counter=0;
		for(int i = tmp.length-1;i>=0;i--) {
			newTmp[counter++]=tmp[i];
		}
		
		return String.join("/", newTmp);
	}
	public String toWebFormat(String input) {
		String[] tmp = input.split("/");
		String[] newTmp = new String[tmp.length];
		int counter=0;
		for(int i = tmp.length-1;i>=0;i--) {
			newTmp[counter++]=tmp[i];
		}
		
		return String.join("-", newTmp);
	}
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
