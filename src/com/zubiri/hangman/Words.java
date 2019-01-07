package com.zubiri.hangman;

import java.util.ArrayList;

public class Words {
	private ArrayList<Word> words = new ArrayList<Word>();

	public ArrayList getWords() {
		return words;
	}

	public void setWords(ArrayList words) {
		this.words = words;
	}

	/**
	 * @author Koldo
	 * @param index of the word in the ArrayList
	 * @return Word class object in the index
	 */
	public Word getWord(int index) {
		return words.get(index);
	}

	/**
	 * @author Koldo
	 * @param Word class object to add to the ArrayList
	 */
	public void addWord(Word word) {
		words.add(word);
	}

	/**
	 * @author Koldo
	 * @param index of the Word you want to modify
	 * @param Word  class object you want to enter in that index
	 */
	public void modifyWord(int index, Word word) {
		words.add(index, word);
	}

	/**
	 * @author Koldo
	 * @param Word class object you want to find
	 * @return index of that word
	 */
	public int findWords(Word word) {
		return words.indexOf(word);
	}

	/**
	 * @author Koldo
	 * @return Word class Object randomly taken
	 */
	public Word getRandomWord() {
		return getWord((int) (Math.random() * words.size()));
	}
}
