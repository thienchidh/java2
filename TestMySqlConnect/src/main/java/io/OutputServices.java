package io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.Objects;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class OutputServices {
	private static final String UTF_8 = "UTF-8";
	private Gson gson;
	private Gson gsonBeauty;

	public OutputServices() {
		super();
		gson = new Gson();
		gsonBeauty = new GsonBuilder().setPrettyPrinting().create();
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

	public boolean writeJson(File file, Object jsonElement) {
		return writeJson(file, jsonElement, false);
	}

	public boolean writeJson(File file, Object jsonElement, boolean isBeautyJson) {
		Objects.requireNonNull(file);
		Objects.requireNonNull(jsonElement);
		String json = (isBeautyJson ? gsonBeauty.toJson(jsonElement) : (gson.toJson(jsonElement)));
		return write(file, json);
	}

	public boolean writeJson(String path, Object jsonElement) {
		Objects.requireNonNull(path);
		return writeJson(new File(path), jsonElement, false);
	}

	public boolean writeJson(String path, Object jsonElement, boolean isBeautyJson) {
		Objects.requireNonNull(path);
		return writeJson(new File(path), jsonElement, isBeautyJson);
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