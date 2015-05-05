package com.thinkinginjava.ex.e15.generics;

public class E20 {

	public static void main(String []args){
		
		E20_caller caller = new E20_caller();
		caller.method(new E20_impl());
		
	}
	
}

interface E20_interface{
	void f();
	void g();
}

class E20_impl implements E20_interface {

	public void f() {
		// TODO Auto-generated method stub
		System.out.println("f()");
	}

	public void g() {
		// TODO Auto-generated method stub
		System.out.println("g()");
	}
	
	public void h(){
		System.out.println("h()");
	}
}

class E20_caller {
	
	public <T extends E20_interface> void method(T sub){
		System.out.println("caller method()");
		sub.f();
		sub.g();
	}
	
}