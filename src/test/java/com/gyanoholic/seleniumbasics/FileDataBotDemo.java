package com.gyanoholic.seleniumbasics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileDataBotDemo {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("./sample.txt"));
		String line = null;
		while((line = br.readLine()) != null) {
			System.out.println("FirstName : "+line.split(",")[0]);
		}
	}
}
