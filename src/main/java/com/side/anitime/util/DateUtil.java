package com.side.anitime.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class DateUtil {

	public static int getLastDateByMonth(String year, String month) {
		Calendar cal = Calendar.getInstance();
		cal.set(Integer.parseInt(year), Integer.parseInt(month) - 1, 1); // 월은 -1해줘야 해당월로 인식
		return cal.getActualMaximum(Calendar.DAY_OF_MONTH); // 해당 달의 마지막 일자
	}

	public static String getFormattedDate(String year, String month,int day) {
		return  year + "-" + month + "-" +String.format("%02d", day);
	}

	public static LocalDateTime getFormattedStartDate(String year, String month, int day) {
		String dayFormat = String.format("%02d", day);
		String date = year + "-" + month + "-" + dayFormat;
		String dateTimeStr = date + " 00:00:00.000";

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
		return LocalDateTime.parse(dateTimeStr, formatter);
	}

	public static LocalDateTime getFormattedEndDate(String year, String month, int day) {
		String dayFormat = String.format("%02d", day);
		String date = year + "-" + month + "-" + dayFormat;
		String dateTimeStr = date + " 23:59:59.999";

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
		return LocalDateTime.parse(dateTimeStr, formatter);
	}

}
