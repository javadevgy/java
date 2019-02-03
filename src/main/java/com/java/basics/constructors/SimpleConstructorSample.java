/**
 * 
 */
package com.java.basics.constructors;

/**
 * @author javadevgy
 *
 */
public class SimpleConstructorSample {

	/**
	 * A class to see constructor calling
	 * 
	 * @author javadevgy
	 *
	 */
	private class A {
		private String name = "Ahmet";
	}

	private class B {
		private void Evaluate() {
			A a = new A();
			a.name = "Mustafa";
			System.out.println(a.name);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SimpleConstructorSample sample = new SimpleConstructorSample();
		A a = sample.new A();
		System.out.println(a.name);
		B b = sample.new B();
		b.Evaluate();
	}
}
