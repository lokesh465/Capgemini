package sample.questions;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FutureTime {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		System.out.println(sdf.format(cal.getTime()));
		cal.add(cal.SECOND, 180);
		System.out.println(sdf.format(cal.getTime()));

	}

}