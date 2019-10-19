package test;

import java.io.File;
import java.io.IOException;

public class TestRemaneFile {
	public static void exec(File file, String newName, String suff) throws IOException {
		if (file.isDirectory()) {
			File[] list = file.listFiles();
			int curIn = 1;
			int curOut = 1;
			for (int i = 0; i < list.length; i++) {
				File e = list[i];
				String name = e.getName();
				if (name.contains(".in.")) {
					exec(e, String.format("%02d", curIn++), "in");
				} else if (name.contains(".out.")) {
					exec(e, String.format("%02d", curOut++), "ans");
				} else {
					exec(e, "", "");
				}
			}
		} else {
			System.out.println(file.getParentFile().getPath() + "\\" + newName + "." + suff);
			boolean b = file.renameTo(new File(file.getParentFile().getPath() + "\\" + newName + "." + suff));
			if (!b) {
				System.err.println(file.getParentFile().getPath() + "\\" + newName + "." + suff);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		String pathname = "dic";

		exec(new File(pathname), "", "");
	}
}
