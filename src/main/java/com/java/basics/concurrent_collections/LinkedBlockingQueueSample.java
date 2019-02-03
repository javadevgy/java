package com.java.basics.concurrent_collections;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueueSample {

	static int value = 0;

	public static void main(String[] args) {
		BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

		Thread read = new Thread(() -> {
			int value;

			while (true) {
				try {
					value = queue.take();// Blocks until queue has an element.
					System.out.println(value + " removed");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread write = new Thread(() -> {
			while (true) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				value++;
				try {
					queue.put(value);// Waits until queue is not full
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(value + " added");
			}
		});

		read.start();
		write.start();
	}
}
