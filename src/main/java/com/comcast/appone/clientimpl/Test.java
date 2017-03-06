package com.comcast.appone.clientimpl;

import org.joda.time.DateTime;

public class Test {

	public static void main(String[] args) {
		DateTime dt = new DateTime();
		System.out.println(dt.getHourOfDay());
	}

	public static void add() {
		System.out.println("for second branch");
	}
}
