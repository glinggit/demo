package com.syy.demo.test;

import java.util.HashMap;
import java.util.Map;

public class Test {
	public void setA(Object o) {
		System.out.println("a");
	}
	
	public void setA(String o) {
		System.out.println("b");
	}
	
	public static void main(String[] args) {
		Test t = new Test();
		t.setA(null);
		
		String a;
		System.out.println("a=");
		
		String b = "aaa";
		System.out.println(b+=1);
		System.out.println(b+100);
		
		
		Map<String, String> map = new HashMap<String, String>();
		
	}
}
