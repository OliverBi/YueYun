package com.yueyun.tool;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

public class TimestampConverter extends StrutsTypeConverter{
	private static final String FORMATDATE = "yyyy-MM-dd";
	
	@SuppressWarnings("rawtypes")
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		if (values == null || values.length == 0) {
			return null;
		}
		Timestamp timestamp = null;
		String timestampString = values[0];
		if(timestampString != null){
			try{
				timestampString += " 00:00:00";
				timestamp = Timestamp.valueOf(timestampString);
			}catch (Exception e) {
				timestamp = null;
			}
		}
		return timestamp;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public String convertToString(Map context, Object o) {
		if(o instanceof Timestamp){
			String tsStr = "";  
		    DateFormat sdf = new SimpleDateFormat(FORMATDATE);  
	        try {  
	            tsStr = sdf.format(o);
	        } catch (Exception e) {  
	        	tsStr = "";
	        }  
	        return tsStr;
		}
		return "";
	}

}
