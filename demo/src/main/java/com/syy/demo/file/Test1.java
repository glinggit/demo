package com.syy.demo.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

public class Test1 {
	public static void main(String[] args) {
		FileInputStream inputStream = null;
		Scanner sc = null;
		String path = "";
		try {
			inputStream = new FileInputStream(path);
			sc = new Scanner(inputStream, "UTF-8");
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				// System.out.println(line);
			}
			// note that Scanner suppresses exceptions
			if (sc.ioException() != null) {
				try {
					throw sc.ioException();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (sc != null) {
				sc.close();
			}
		}
	}
	
	/**
	 * Apache Commons IO流

	      同样也可以使用Commons IO库实现，利用该库提供的自定义LineIterator:
	 * @throws IOException
	 */
	public void test() throws IOException {
		File theFile = new File("");
		LineIterator it = FileUtils.lineIterator(theFile, "UTF-8");
		try {
		    while (it.hasNext()) {
		        String line = it.nextLine();
		        // do something with line
		    }
		} finally {
		    LineIterator.closeQuietly(it);
		}
	}
	
	
	
}
