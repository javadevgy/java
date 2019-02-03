package com.java.basics.io.streams;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamSample {

	public static void main(String[] args) {
		String fileName = "src/main/java/com/java/basics/io/streams/TrialOut.txt";
		String message = "Ve aleyk�mselam.\nYou're welcome.";
		
		try (FileOutputStream stream = new FileOutputStream(fileName)) {
			stream.write(message.getBytes());
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
