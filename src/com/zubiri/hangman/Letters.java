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

	/**
	 * @author Koldo
	 * @param index   in the array of the character
	 * @param letters - the char you want to enter in the letters array
	 *                <p>
	 *                Adds a character in the position you give. <br>
	 *                If you enter more than the length of the array it will print a
	 *                message.
	 *                </p>
	 */
	public void setLetter(int index, char letters) {
		if (lettersCounter < 3) {
			this.letters[index] = letters;
		} else {
			System.out.println("You can't add more than 3 times");
		}
	}

	public int getLettersCounter() {
		return lettersCounter;
	}

	public void setLettersCounter(int lettersCounter) {
		this.lettersCounter = lettersCounter;
	}

	public char getPosibleLetter() {
		return possibleLetter;
	}

	public void setPossibleLetter(String possibleLetter) {
		possibleLetter.trim().toLowerCase();
		// just in case the user has entered more than one word
		String[] letterArray = possibleLetter.split(" ");
		// check that the player enters just a letter
		// check that the player enters just a letter
		if (letterArray.length == 1) {
			if (letterArray[0] == "0" || letterArray[0] == "1" || letterArray[0] == "2" || letterArray[0] == "3"
					|| letterArray[0] == "4" || letterArray[0] == "5" || letterArray[0] == "6" || letterArray[0] == "7"
					|| letterArray[0] == "8" || letterArray[0] == "9") {
				this.possibleLetter = possibleLetter.charAt(0);
			} else
				System.out.println("That's not a letter. Try again.");
		} else
			System.out.println("Don't cheat,  please enter just a letter.");
	}

	/**
	 * @author Koldo
	 * @returns the length of the array
	 */
	public int length() {
		return letters.length;
	}

	public void letterIn(char letter, Word word) {
		// Open a loop that will go checking if the letter the player entered is in the
		// surname
		for (int index = 0; index < word.getWord().length(); index++) {
			if (word.getWord().charAt(index) == letter) {
				/*
				 * If the character matches, open a loop which will check if the player had
				 * entered that letter before
				 */
				boolean found = true;
				int index2 = 0;
				while (index2 < lettersCounter && !found) {
					if (letters[index2] == letter) {
						found = true;
					}
					index2++;
				}
				/*
				 * find for a repeated guess character as times as characters you've saved in
				 * the array
				 */
				if (!found) {
					// If he/she had not done so, save the letter in the array 'guessed'
					letters[lettersCounter] = letter;
					// Increment once the variable 'guessedCounter' for a future possible letter
					lettersCounter++;
					// Define the variable 'found' as true so as to get out of the loop
				}
			}
		}
	}
}
