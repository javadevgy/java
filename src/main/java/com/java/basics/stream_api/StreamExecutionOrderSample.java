package com.java.basics.stream_api;

import java.util.stream.IntStream;

public class StreamExecutionOrderSample {

	public static void main(String[] args) {
		IntStream stream = IntStream.of( 1, 2, 3, 4, 5).filter(x -> {
			System.out.println("Filter " + x);
			return x % 2 == 0;
		});
		System.out.println("Note that stream is not executed yet, since there is no terminal operation in it.");
		stream.forEach(x -> System.out.println("Foreach " + x));
		System.out.println("Now the stream is executed since there is a forEach, a terminal operation.");
		System.out.println(
				"Be aware that when filtering is done for an element, it is immediately passed to forEach, not waiting to finish all filtering first.");
	}
}
