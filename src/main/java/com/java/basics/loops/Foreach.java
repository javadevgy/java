package com.java.basics.loops;

import java.util.*;

public class Foreach {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>(Arrays.asList("Ahmet", "Mustafa"));

		for (String item : list)
			System.out.println(item);

		list.forEach(a -> System.out.println(a));
	}
}
