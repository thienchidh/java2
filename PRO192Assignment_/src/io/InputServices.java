package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class InputServices {
	private static final String UTF_8 = "UTF-8";

	public InputServices() {
		super();
	}

	public List<String> readFile(File file) throws IOException {
		List<String> list = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), UTF_8))) {

			String line;
			while ((line = br.readLine()) != null) {
				list.add(line);
			}
		}
		return list;
	}

	public List<String> readFile(String path) throws IOException {
		return readFile(new File(path));
	}

	public String readFileAsString(File file) throws IOException {

		StringBuilder sb = new StringBuilder();

		List<String> list = readFile(file);
		for (String string : list) {
			sb.append(string).append('\n');
		}

		return sb.toString();
	}

	public String readFileAsString(String path) throws IOException {

		return readFileAsString(new File(path));
	}

	public Object readObject(File file) throws IOException, ClassNotFoundException {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
			return ois.readObject();
		}
	}

	public Object readObject(String path) throws ClassNotFoundException, IOException {
		return readObject(new File(path));
	}

}