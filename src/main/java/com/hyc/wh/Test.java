package com.hyc.wh;

import java.util.Calendar;

public class Test {

	public static void main(String[] args) {
		Calendar now = Calendar.getInstance();
		int mouth=now.get(Calendar.MONTH);
		System.out.println(Math.ceil((mouth+1)*1.0/3));

	}

}
