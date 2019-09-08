package ex5;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class MyWordManage {
	private Scanner sc = new Scanner(System.in);
	private Map<String, String> engWords;

	public MyWordManage() {
		super();
		engWords = new HashMap<>();
	}

	private void addAWord() {
		System.out.println("English: ");
		String eng = sc.nextLine();
		System.out.println("Vietnamese: ");
		String vi = sc.nextLine();

		if (engWords.put(eng, vi) == null) {
			System.out.println("add Success");
		} else {
			System.out.println("updated!");
		}
	}

	private void deleteAWord() {

		System.out.println("english word: ");
		String key = sc.nextLine();

		if (engWords.remove(key) != null) {
			System.out.println();
		} else {
			System.err.println("Not found!");
		}

	}

	private void handle(int choice) {
		switch (choice) {
		case 1: {
			addAWord();
			break;
		}
		case 2: {
			System.out.println();
			for (Entry<String, String> e : engWords.entrySet()) {
				System.out.println(e.getKey() + "-" + e.getValue());
			}
			System.out.println();
			break;
		}
		case 3: {
			deleteAWord();
			break;
		}
		case 4: {
			searchAWord();
			break;
		}
		case 0: {
			System.exit(0);
		}
		default: {
			System.out.println("???");
			break;
		}
		}

	}

	private void searchAWord() {
		System.out.println("english word: ");
		String key = sc.nextLine().trim();
		if (engWords.containsKey(key)) {
			System.out.println(engWords.get(key));
		} else {
			System.err.println("Not Found!");
		}
	}

	public void run() {
		while (true) {
			try {
				showMenu();
				int choice = Integer.parseInt(sc.nextLine().trim());
				handle(choice);

			} catch (Exception e) {
				System.err.println(e);
			}
		}
	}

	private void showMenu() {
		System.out.println("----------------");
		System.out.println("1. Add a word");
		System.out.println("2. Display all word");
		System.out.println("3. Delete a word");
		System.out.println("4. Search word");
		System.out.println("0. Exit");
		System.out.print("> ");
	}
}
