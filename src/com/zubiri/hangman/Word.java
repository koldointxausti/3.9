package com.zubiri.hangman;

public class Word {
	private String word;
	
	public String getWord() {
		return this.word;
	}
	public void setWord(String word) {
		if(hasNumbers(word)==false) {
			
		}
	}
	
	private boolean hasNumbers(String word) {
		boolean fine=false;
		word.toLowerCase().trim();
		char[] characters = word.toCharArray();
		for (int i = 0; i<word.length();i++) {
			if(characters[i]=='0'||characters[i]=='1'||characters[i]=='2'||characters[i]=='3'||characters[i]=='4'||characters[i]=='5'||characters[i]=='6'||characters[i]=='7'||characters[i]=='8'||characters[i]=='9') {
				fine=true;
				break;
			}
		}
		return fine;
	}
}
