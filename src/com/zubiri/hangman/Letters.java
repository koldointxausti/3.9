package com.zubiri.hangman;

public class Letters {
	private char[] letters = new char[3];
	private int lettersCounter = 0;
	private char possibleLetter;

	public char[] getletters() {
		return letters;
	}

	/**
	 * @author Koldo
	 * @param index of the character you want to get
	 * @return the character in the position you give
	 */
	public char getLetter(int index) {
		return letters[index];
	}

	public void setLetters(char[] letters) {
		this.letters = letters;
	}

	public boolean setLetter(char letter) {
		boolean fine = true;
		if (lettersCounter < 3) {
			this.letters[lettersCounter] = letter;
			lettersCounter++;
		} else {
			fine=false;
		}
		return fine;
	}

	public int getLettersCounter() {
		return lettersCounter;
	}

	public char getPosibleLetter() {
		return possibleLetter;
	}

	public boolean setPossibleLetter(String possibleLetter) {
		boolean fine = false;
		possibleLetter.trim().toLowerCase();
		// just in case the user has entered more than one word
		String[] letterArray = possibleLetter.split(" ");
		// check that the player enters just a letter
		// check that the player enters just a letter
		if (letterArray.length == 1) {
			if (letterArray[0] == "0" || letterArray[0] == "1" || letterArray[0] == "2" || letterArray[0] == "3"
					|| letterArray[0] == "4" || letterArray[0] == "5" || letterArray[0] == "6" || letterArray[0] == "7"
					|| letterArray[0] == "8" || letterArray[0] == "9") {
				fine = false;
			}else {
				this.possibleLetter = letterArray[0].charAt(0);
				fine=true;
				setLetter(this.possibleLetter);
			}
		}
		return fine;
	}

	/**
	 * @author Koldo
	 * @returns the length of the array
	 */
	public int length() {
		return letters.length;
	}

	public void letterIn(char letter, Word word) {
		// Open a loop that will go checking if the letter the player entered is in the word
		for (int index = 0; index < word.getWord().length(); index++) {
			if (word.getWord().charAt(index) == letter) {
				/*
				 * If the character matches, open a loop which will check if the player had
				 * entered that letter before
				 */
				boolean found = true;
				int index2 = 0;
				/*
				 * find for a repeated guess character as times as characters you've saved in
				 * the array
				 */
				while (index2 < lettersCounter && !found) {
					if (letters[index2] == letter) {
						found = true;
					}
					index2++;
				}
				
				if (!found) {
					// If he/she had not done so, save the letter in the array 'guessed'
					setLetter(letter);
					// Define the variable 'found' as true so as to get out of the loop
					found =true;
				}
			}
		}
	}
}
