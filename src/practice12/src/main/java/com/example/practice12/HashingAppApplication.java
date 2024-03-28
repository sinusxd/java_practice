package com.example.practice12;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

@SpringBootApplication
public class HashingAppApplication implements CommandLineRunner {

	private static String sourceFileName;
	private static String targetFileName;

	public static void main(String[] args) {
		System.out.println("Received arguments: " + Arrays.toString(args));
		if (args.length >= 2) {
			sourceFileName = args[0];
			targetFileName = args[1];
		} else {
			System.out.println("Insufficient arguments. Please provide source and target file names.");
			System.exit(1);
		}
		SpringApplication.run(HashingAppApplication.class, args);
	}

	@Override
	public void run(String[] args) {
		// Пустой метод run, так как логика аргументов перенесена в main
	}

	@PostConstruct
	public void init() throws IOException, NoSuchAlgorithmException {
		System.out.println("Initializing with source file: " + sourceFileName);
		File sourceFile = new File(sourceFileName);
		String hashedContent;

		if (sourceFile.exists()) {
			byte[] fileContent = Files.readAllBytes(sourceFile.toPath());
			hashedContent = Base64.getEncoder().encodeToString(MessageDigest.getInstance("SHA-256").digest(fileContent));
		} else {
			hashedContent = "null";
		}

		try (FileWriter writer = new FileWriter(targetFileName)) {
			writer.write(hashedContent);
			System.out.println("Hashed content written to " + targetFileName);
		}
	}

	@PreDestroy
	public void destroy() {
		File sourceFile = new File(sourceFileName);
		if (sourceFile.exists() && !sourceFile.delete()) {
			System.out.println("Could not delete the source file.");
		} else {
			System.out.println("Source file " + sourceFileName + " deleted successfully.");
		}
	}
}
