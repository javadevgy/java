package com.java.basics.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;

public class DirectoryDeleteSample {

	public static void main(String[] args) {
		String base = "src/main/java/com/java/basics/nio";
		Path temporary = Paths.get(base + "/temporary");
		Path inner = Paths.get(base + "/temporary/inner");
		try {
			System.out.println("Directory to be generated: " + temporary.toAbsolutePath());
			System.out.println("\nCleaning first if exists..\n");
			deleteFolder(temporary);// If directory already exists then creating will give an exception, so we
			// delete it.
			Files.createDirectory(temporary);
			Files.createDirectory(inner);
			System.out.println("\nContent of parent of " + temporary + "\n");
			Files.list(temporary.getParent()).forEach(x -> System.out.println(x.getFileName()));
			System.out.println("\nContent of " + temporary + "\n");
			Files.list(temporary).forEach(x -> System.out.println(x.getFileName()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void deleteFolder(Path folder) throws IOException {
		if (!Files.exists(folder))
			return;

		Files.walk(folder).sorted(Comparator.reverseOrder()).peek(f -> System.out.println("Deleting " + f))
				.forEach(t -> {
					try {
						Files.deleteIfExists(t);
					} catch (IOException e) {
						e.printStackTrace();
					}
				});
	}
}
