package userInterface;
import com.zubiri.hangman.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Surnames surname = new Surnames();
		//add default surnames
		surname.addSurname("lazkano");
		surname.addSurname("intxausti");
		surname.addSurname("artola");
		surname.addSurname("alberdi");
		surname.addSurname("lekubide");
		surname.addSurname("ortiz");
		surname.addSurname("gonzalez");
		//get a random surname among them
		String randomSurname= surname.getRandomSurname();
		//ask the user for the first letter
		System.out.println("Good luck, start with the first letter.");
		// Create a char array with the length of the maximum quantity of letters the player can guess
		char guessed[] = new char [3];
		int guessedCounter = 0;
		//print the wodd with voids
		for(int i= 0; i<randomSurname.length();i++) 
			System.out.println("_ ");
		//Open a loop that will go asking to the player for a possible letter in each turn
		int flag = 0;
		while(flag<3) {
			//check that the player doesn't enter a number
			if(!sc.hasNextInt()) {
				String possibleLetter = sc.nextLine().toLowerCase().trim();
				String[] letterArray = possibleLetter.split(" ");
				//check that the player enters just a letter
				if(letterArray.length==1) {
					// Open a loop that will go checking if the letter the player entered is in the surname
					for(int i = 0; i < randomSurname.length(); i++) {
						if(randomSurname.charAt(i)==letterArray[0].charAt(0)) {
							
						}
					}
				}else
					System.out.println("Don't cheat,  please enter just a letter.");
			}else
				System.out.println("That's not a letter. Try again.");
		}
		
	}

}
