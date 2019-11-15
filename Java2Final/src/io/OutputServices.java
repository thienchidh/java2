package io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.Objects;

public class OutputServices {
	private static final String UTF_8 = "UTF-8";

	public OutputServices() {
		super();
	}

	public boolean write(File file, String content) {
		Objects.requireNonNull(file);
		try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), UTF_8))) {
			bw.write(content);
			bw.newLine();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public boolean write(String path, String content) {
		Objects.requireNonNull(path);
		return write(new File(path), content);
	}

	private boolean writeObject(File file, Object o) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
			oos.writeObject(o);
		} catch (IOException e) {
			return false;
		}

		return true;
	}

	public boolean writeObject(String path, Object o) {
		Objects.requireNonNull(path);
		return writeObject(new File(path), o);
	}

}