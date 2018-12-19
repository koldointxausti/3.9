package com.zubiri.hangman;
import java.util.ArrayList;
import java.util.Random;

public class Surnames {
	private ArrayList<String> surnames = new ArrayList<String>();
	//private String randomNumber;
	
	public ArrayList getSurnames() {
		return surnames;
	}
	public void setSurnames(ArrayList<String> surnames) {
		this.surnames=surnames;
	}
	
	public String getSurname(int index) {
		return surnames.get(index);
	}
	public void setSurname(String surname, int index) {
		surnames.add(index, surname);
	}
	
	public void addSurname(String surname) {
		surnames.add(surname.toLowerCase());
	}
	public void deleteSurname(int index) {
		surnames.remove(index);
	}
	
	public int findSurname(String surname) {
		int position = -1;
		for(int i=0; i<surnames.size();i++) {
			if(surname.compareTo(surnames.get(i))==0) {
				position = i;
				break;
			}
		}
		return position;
	}
	public String getRandomSurname() {
		return surnames.get(new Random().nextInt(surnames.size()));
	}
	
	
}
