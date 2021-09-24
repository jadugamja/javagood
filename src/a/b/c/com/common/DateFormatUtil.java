package a.b.c.com.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class DateFormatUtil {

	// 연월일까지 나오는 시간
	public static String ymdFormat() {		
		return new SimpleDateFormat("yyyyMMdd").format(new Date());
	}
	
	// 연월까지 나오는 시간
	public static String ymFormat() {		
		return new SimpleDateFormat("yyyyMM").format(new Date());
	}
	
	// 연까지 나오는 시간
	public static String yFormat() {		
		return new SimpleDateFormat("yyyy").format(new Date());
	}

	public static String ymdFormats(String ymdFlag){
		
		String y = "";
		if ("D".equals(ymdFlag.toUpperCase())){
			y = DateFormatUtil.ymdFormat();
		}
		if ("M".equals(ymdFlag.toUpperCase())){
			y = DateFormatUtil.ymFormat();
		}
		if ("Y".equals(ymdFlag.toUpperCase())){
			y = DateFormatUtil.yFormat();
		}
		if ("N".equals(ymdFlag.toUpperCase())){
			y = "";
		}
		
		return y;
	}	

	
	// main 시작
	public static void main(String args[]) {
		
	} // end of main

} // end of DateFormatUtil
