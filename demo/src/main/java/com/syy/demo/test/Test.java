package com.syy.demo.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
	public void setA(Object o) {
		System.out.println("a");
	}
	
	public void setA(String o) {
		System.out.println("b");
	}
	
	public static void main(String[] args) {
//		Test t = new Test();
//		t.setA(null);
//		
//		String a;
//		System.out.println("a=");
//		
//		String b = "aaa";
//		System.out.println(b+=1);
//		System.out.println(b+100);
//		
//		
//		Map<String, String> map = new HashMap<String, String>();
		

		String a = "aaabbcccddd+++ww";
		String b = a.replace("(\\w)\\1*", "$1");
		System.out.println(b);

		
		
		
		
		String str = "111111kakkkkkkkkkkwwwaacbbdAAA";
		String s = "";
		Matcher m = Pattern.compile("(\\w)\\1*").matcher(str);
		while (m.find()) {
			s += m.group().subSequence(0, 1);
		}
		System.out.println(s);

		
		
	}
}
