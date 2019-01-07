package hangman;

import com.zubiri.hangman.*;

import java.util.Iterator;
import java.util.Scanner;

public class Hangman {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to the famous HANGMAN game.");
		System.out.println("You will have to guess which surname of the people in class is hidden between the voids.");
		System.out.println(
				"For this, you will be able to enter 3 letters that may appear in the surname, or not. After this, you will only have a chance to guess the surname and win the game.");
		boolean playAgain = true;
		while (playAgain == true) {
			Words words = new Words();
			// add default surnames
			words.addWord(new Word("lazkano"));
			words.addWord(new Word("intxausti"));
			words.addWord(new Word("artola"));
			words.addWord(new Word("alberdi"));
			words.addWord(new Word("lekubide"));
			words.addWord(new Word("ortiz"));
			words.addWord(new Word("gonzalez"));
			// get a random surname among them
			Word word = new Word(words.getRandomWord().getWord());
			System.out.println("Good luck, start with the first letter.");
			Letters letters = new Letters();
			// print the word using underscores
			word.printUnderscores(letters);
			// Open a loop that will go asking to the player for a possible letter in each
			// turn
			int flag = 0;
			while (flag < 3) {
				// ask the user for a letter
				letters.setPossibleLetter(sc.nextLine());
				//word.hasLetter(letters.getLetter(letters.getLettersCounter()-1));
				//letters.letterIn(letters.getPosibleLetter(), word);
				flag++;// define that the user has use one more time (until 3 times)
				// print the current situation of the word
				word.printUnderscores(letters);
				// print how many tries do you have left
				if (flag == 1)
					System.out.println("You can enter just two letters more");
				else if (flag == 2)
					System.out.println("You can enter just a letter more");
			}
			System.out.println("It's time, you gotta try to guess to whole word");
			boolean wordEntered = false;
			while (wordEntered == false) {
				String playerWord = sc.nextLine();
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
					if (hasNumber == false) {
						wordEntered = true; // to go out of the loop
						if (playerWordArray[0].compareTo(word.getWord()) == 0)
							System.out.println("Congrats, you won the game");
						else
							System.out.println("Sorry, you lost. The surname was " + word.getWord());
					} else
						System.out.println("Please, enter a real number (no numbers)");
				} else
					System.out.println("Please enter just one word");
			}
			System.out.println("Would you like to play again? (y/n)");
			boolean askAgain = true;
			while (askAgain) {
				String answer = sc.next().toLowerCase();
				sc.nextLine();
				switch (answer) {
				case "y":
					askAgain = false; // get out of this loop but no out of the biggest loop (playAgain)
					break;
				case "n":
					askAgain = false; // get out of this loop
					playAgain = false; // get out of the biggest loop (playAgain)
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
