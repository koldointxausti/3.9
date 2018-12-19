package userInterface;

import com.zubiri.hangman.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to the famous HANGMAN game.");
		System.out.println("You will have to guess which surname of the people in class is hidden between the voids.");
		System.out.println(
				"For this, you will be able to enter 3 letters that may appear in the surname, or not. After this, you will only have a chance to guess the surname and win the game.");
		boolean playAgain = true;
		while (playAgain == true) {
			Surnames surname = new Surnames();
			// add default surnames
			surname.addSurname("lazkano");
			surname.addSurname("intxausti");
			surname.addSurname("artola");
			surname.addSurname("alberdi");
			surname.addSurname("lekubide");
			surname.addSurname("ortiz");
			surname.addSurname("gonzalez");
			// get a random surname among them
			String randomSurname = surname.getRandomSurname();
			// ask the user for the first letter
			System.out.println("Good luck, start with the first letter.");
			// Create a char array with the length of the maximum quantity of letters the
			// player can guess
			char guessed[] = new char[3];
			int guessedCounter = 0;
			// print the word with voids
			for (int i = 0; i < randomSurname.length(); i++)
				System.out.println("_ ");
			// Open a loop that will go asking to the player for a possible letter in each
			// turn
			int flag = 0;
			while (flag < 3) {
				// check that the player doesn't enter a number
				if (!sc.hasNextInt()) {
					String possibleLetter = sc.nextLine().toLowerCase().trim();
					// just in case the user has entered more than one word
					String[] letterArray = possibleLetter.split(" ");
					// check that the player enters just a letter
					if (letterArray.length == 1) {
						Letter letter = new Letter();
						for(int i = 0; i<randomSurname.length();i++) {
							if(letter.findLetterIn(randomSurname , letterArray[0].charAt(0))) {
								
							}
								
						}
						
						// Open a loop that will go checking if the letter the player entered is in the
						// surname
						for (int index = 0; index < randomSurname.length(); index++) {
							if (randomSurname.charAt(index) == letterArray[0].charAt(0)) {
								/*
								 * If the character matches, open a loop which will check if the player had
								 * entered that letter before
								 */
								boolean found = false;
								int index2 = 0;
								/*
								 * find for a repeated guess character as times as characters you've saved in
								 * the array
								 */
								while (index2 < guessedCounter && !found) {
									if (guessed[index2] == letterArray[0].charAt(0)) {
										found = true;
									}
									index2++;
								}
								if (!found) {
									// If he/she had not done so, save the letter in the array 'guessed'
									guessed[guessedCounter] = letterArray[0].charAt(0);
									// Increment once the variable 'guessedCounter' for a future possible letter
									guessedCounter++;
									// Define the variable 'found' as true so as to get out of the loop
								}

							}
						}
						flag++;// define that the user has use one more time (until 3 times)
					} else
						System.out.println("Don't cheat,  please enter just a letter.");
				} else
					System.out.println("That's not a letter. Try again.");
				// print the current situation of the word
				for (int i = 0; i < randomSurname.length(); i++) {
					for (int j = 0; j < guessed.length; j++) {
						if (guessed[j] == randomSurname.charAt(i)) {
							System.out.println(randomSurname.charAt(i) + " ");
						} else
							System.out.println("_ ");
					}
				}
				// print how many tries do you have left
				if (flag == 1)
					System.out.println("You can enter just two letters more");
				else if (flag == 2)
					System.out.println("You can enter just a letter more");
			}
			System.out.println("It's time, you gotta try to guess to whole word");
			boolean wordEntered = false;
			while (wordEntered == false) {
				String playerWord = sc.nextLine().toLowerCase().trim();
				// check the user has entered just one word
				String[] playerWordArray = playerWord.split(" ");
				if (playerWordArray.length == 1) {
					// check if the word the user enters has a number
					boolean hasNumber = false;
					for (int i = 0; i < playerWordArray[0].length(); i++) { // taking each letter
						for (int j = 0; j < 9; j++) { // comparing with numbers
							// if this letter is equal to any number
							if (playerWordArray[0].charAt(i) == (char) j) {
								hasNumber = true;
								break;
							}
						}
					}
					if (hasNumber = false) {
						wordEntered = true; // to go out of the loop
						if (playerWordArray[0].compareTo(randomSurname) == 0)
							System.out.println("Congrats, you won the game");
						else
							System.out.println("Sorry, you lost. The surname was " + randomSurname);
					} else
						System.out.println("Please, enter a real number (no numbers)");
				} else
					System.out.println("Please enter just one word");
			}
			System.out.println("Would you like to play again? (y/n)");
			boolean askAgain = true;
			while(askAgain) {
				String answer = sc.next().toLowerCase();
				sc.nextLine();
				switch (answer) {
				case "y":
					askAgain=false; //get out of this loop but no out of the biggest loop (playAgain)
					break;
				case "n":
					askAgain=false; //get out of this loop
					playAgain=false; //get out of the biggest loop (playAgain)
					break;
				default:
					System.out.println("Please, select a posible answer ('y' for yes/ 'n' for no)");
					break;
				}
			}
		}
		sc.close();
	}

}
