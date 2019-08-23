package model;

public class DictionaryWord {
	private String word;
	private String meanings;

	public DictionaryWord(String word, String meanings) {
		super();
		this.word = word;
		this.meanings = meanings;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DictionaryWord other = (DictionaryWord) obj;
		if (meanings == null) {
			if (other.meanings != null)
				return false;
		} else if (!meanings.equals(other.meanings))
			return false;
		if (word == null) {
			if (other.word != null)
				return false;
		} else if (!word.equals(other.word))
			return false;
		return true;
	}

	public String getMeanings() {
		return meanings;
	}

	public String getWord() {
		return word;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((meanings == null) ? 0 : meanings.hashCode());
		result = prime * result + ((word == null) ? 0 : word.hashCode());
		return result;
	}

	public void setMeanings(String meanings) {
		this.meanings = meanings;
	}

	public void setWord(String word) {
		this.word = word;
	}

	@Override
	public String toString() {
		return String.format("%s\n%s", word, meanings);
	}

}
