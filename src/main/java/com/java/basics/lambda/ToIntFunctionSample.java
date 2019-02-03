package com.java.basics.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.ToIntFunction;

public class ToIntFunctionSample {

	public static void main(String[] args) {
		List<String> numbers = new ArrayList<>(Arrays.asList("3", "2", "5"));
		ToIntFunction<String> mapper = Integer::parseInt;
		int[] numberArray = numbers.stream().mapToInt(mapper).toArray();
		System.out.println(Arrays.toString(numberArray));
	}

}
