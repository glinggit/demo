package com.syy.demo.test;

import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Test {
	public void setA(Object o) {
		System.out.println("a");
	}

	public void setA(String o) {
		System.out.println("b");
	}

	public static void main(String[] args) {
		// Test t = new Test();
		// t.setA(null);
		//
		// String a;
		// System.out.println("a=");
		//
		// String b = "aaa";
		// System.out.println(b+=1);
		// System.out.println(b+100);
		//
		//
		// Map<String, String> map = new HashMap<String, String>();

		// String a = "aaabbcccddd+++ww";
		// String b = a.replace("(\\w)\\1*", "$1");
		// System.out.println(b);
		//
		// String str = "111111kakkkkkkkkkkwwwaacbbdAAA";
		// String s = "";
		// Matcher m = Pattern.compile("(\\w)\\1*").matcher(str);
		// while (m.find()) {
		// s += m.group().subSequence(0, 1);
		// }
		// System.out.println(s);
		
		HashMap<String, String> hashMap = new HashMap<String, String>();
		int MAXIMUM_CAPACITY = 1 << 30;
		System.out.println(MAXIMUM_CAPACITY);
		

//		String str = "123wabbdsafffrrrtttlkjhy";
//		Test test = new Test();
//		int p = test.Method(str);
//		String result = str.charAt(p) + "";
//		System.out.println(result);
//
//		char abc = 'a';
//		int a1 = abc;
//		System.out.println(a1);
//
//		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(8);
//		scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
//			@Override
//			public void run() {
//				System.out.println("hello world");
//			}
//		}, 1, 3, TimeUnit.SECONDS);

	}

	public int Method(String str) {
		int position = -1;
		int length = str.length();
		for (int i = 0; i < length; i++) {
			char c = str.charAt(i);
			if ((str.indexOf(c, i + 1)) != -1) {
				position = i;
				break;
			}
		}
		return position;
	}
}
