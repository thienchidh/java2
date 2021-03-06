package controls;

import java.util.Set;
import java.util.TreeSet;

import model.DictionaryWord;

public class MyDictionary {

	private Set<DictionaryWord> dictionaryWords;

	public MyDictionary() {
		super();
		dictionaryWords = new TreeSet<>((o1, o2) -> {
			int x = o1.getWord().compareTo(o2.getWord());
			if (x == 0) {
				return o1.getMeanings().compareTo(o2.getMeanings());
			}
			return x;
		});
	}

	public void run() {

		dictionaryWords.add(new DictionaryWord("word", "meanings"));
		dictionaryWords.add(new DictionaryWord("bank robber", "Steals money from a bank"));
		dictionaryWords.add(new DictionaryWord("burglar", "Breaks into a home to steal things"));
		dictionaryWords.add(new DictionaryWord("forger", "Makes an illegal copy of something"));
		dictionaryWords.add(new DictionaryWord("hacker", "Breaks into a computer system"));
		dictionaryWords.add(new DictionaryWord("hijacker", "Takes control of an airplane"));
		dictionaryWords.add(new DictionaryWord("kidnapper", "Holds someone for ransom money"));
		dictionaryWords.add(new DictionaryWord("mugger", "Attacks and steals money from someone"));
		dictionaryWords.add(new DictionaryWord("murderer", "Kills another person"));
		dictionaryWords.add(new DictionaryWord("murderer", "Kills another person"));
		dictionaryWords.add(new DictionaryWord("murderer", "Kills another person"));
		dictionaryWords.add(new DictionaryWord("murderer", "Kills another person"));
		dictionaryWords.add(new DictionaryWord("murderer", "Kills another person"));
		dictionaryWords.add(new DictionaryWord("murderer", "Kills another person"));

		System.out.println("size: " + dictionaryWords.size());

		int i = 1;
		for (DictionaryWord e : dictionaryWords) {
			System.out.println((i++) + ". " + e.toString());
		}

	}
}
