package com.zubiri.hangman;

public class Letter {
	private char[] letters = new char[3];
	private int guessedLetters;
	
	
	
	public boolean findLetterIn(String surname, char letter) {
		boolean found = true;
		for (int i = 0; i < surname.length(); i++) {
			if (surname.charAt(i) ==letter) {
				/* If the character matches, open a loop which will check if the player had
				 entered that letter before */
				found = false;
			}
		}
		return found;
	}
}
