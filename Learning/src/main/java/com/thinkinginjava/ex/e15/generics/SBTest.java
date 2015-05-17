package com.thinkinginjava.ex.e15.generics;

import org.junit.Test;


public class SBTest {
	
	
	@Test
	public void testSB(){
		testSB1();
		testSB2();
	}
	
	@Test
	public void testSB1(){
		StringBuffer sb = new StringBuffer();
		long start = System.currentTimeMillis();
		for(int i=0;i<1000000;i++){
			String str = "b";
			sb.append("a" + str);
		}
		long end = System.currentTimeMillis();
		System.out.println("time cost:" + (end-start));
	}
	@Test
	public void testSB2(){
		StringBuffer sb = new StringBuffer();
		long start = System.currentTimeMillis();
		for(int i=0;i<1000000;i++){
			String str = "b";
			sb.append("a");
			sb.append(str);
//			sb.append("c");
		}
		long end = System.currentTimeMillis();
		System.out.println("time cost:" + (end-start));
	}

}
