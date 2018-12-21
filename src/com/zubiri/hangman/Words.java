package com.zubiri.hangman;
import java.util.ArrayList;
import java.util.Random;

public class Words {
	private ArrayList<Word> words = new ArrayList<Word>();
	//private String randomNumber;
	
	public ArrayList getWords() {
		return words;
	}
	public void setWords(ArrayList<Words> words) {
		this.words=words;
	}
	
	public Word getWords(int index) {
		return words.get(index);
	}
	public void setWords(Word word, int index) {
		words.add(index, word);
	}
	
	public void addWords(Word word) {
		words.add(word.toLowerCase());
	}
	public void deleteWords(int index) {
		words.remove(index);
	}
	
	public int findWords(Word word) {
		int position = -1;
		for(int i=0; i<words.size();i++) {
			if(word.compareTo(words.get(i))==0) {
				position = i;
				break;
			}
		}
		return position;
	}
}
