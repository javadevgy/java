package com.java.basics.strings;

public class StringBufferSample {

	public static void main(String[] args) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("javadevgy");
		buffer.append(" java");
		System.out.println(buffer.toString());
		System.out.println(buffer.charAt(3));
	}
}
