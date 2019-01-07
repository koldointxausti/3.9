package com.zubiri.hangman;

import java.util.Iterator; 

public class Word {
	private String word;

	public Word(String word) {
		setWord(word);
	}

	public String getWord() {
		return this.word;
	}

	/**
	 * @author Koldo
	 * @param word you want to save (String)
	 *             <p>
	 *             Sets a Word checking that it is <strong>an only word</strong> and
	 *             <strong>it is not a number</strong>
	 *             </p>
	 *             <p>
	 *             In case it's not correct a message will be printed on the screen
	 *             </p>
	 */
	public boolean setWord(String word) {
		boolean fine = false;
		checkWord(word);
		if (checkWord(word)) {
			this.word = word.toLowerCase();
			fine = true;
		}
		return fine;
	}

	/**
	 * @author Koldo
	 * @param word you want to check (String)
	 * @return true if the word is <strong>an only word</strong> and <strong>it has
	 *         not numbers</strong>
	 */
	public boolean checkWord(String word) {
		boolean fine = false;
		word.trim();
		String[] numberOfWords = word.split(" ");
		if (numberOfWords.length == 1) {
			char[] characters = word.toCharArray();
			boolean isNumber = false;
			for (int i = 0; i < word.length(); i++) {
				if (characters[i] == '0' || characters[i] == '1' || characters[i] == '2' || characters[i] == '3'
						|| characters[i] == '4' || characters[i] == '5' || characters[i] == '6' || characters[i] == '7'
						|| characters[i] == '8' || characters[i] == '9') {
					isNumber = true;
					break;
				}
			}
			if (isNumber == false)
				fine = true;
			else
				System.out.println("You can't enter a number");
		} else
			System.out.println("The word has not been set becouse it has to be only a word.");
		return fine;
	}

	/**
	 * @author Koldo
	 * @param letter you want to find in the word
	 * @return true if the word has that letter or <strong>false</strong> if it has
	 *         not
	 */
	public boolean hasLetter(char letter) {
		boolean itHas = false;
		char[] letters = word.toCharArray();
		for (int i = 0; i < letters.length; i++) {
			if (letters[i] == letter) {
				itHas = true;
				break;
			}
		}
		return itHas;
	}

	/**
	 * @author Koldo
	 * @param Letters class object whose situation you want to print by underscores
	 *                <p>
	 *                Prints the current situation of the word
	 *                </p>
	 */
	public void printUnderscores(Letters letters) {
		//
		for (int i = 0; i < word.length(); i++) {
			boolean found = false;
			for (int j = 0; j < letters.length(); j++) {
				if (letters.getLetter(j) == word.charAt(i)) {
					System.out.print(word.charAt(i) + " ");
					found=true;
				}
			}
			if (!found) {
				System.out.print("_ ");
			}
		}
	}

}
