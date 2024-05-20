package uke7.loekkeinterface;

import java.util.List;

public class ListCharPrinter implements LoekkePrintInterface<List<Character>> {

	@Override
	public void printCharacters(List<Character> obj) {
			
		for (char c : obj) {
			System.out.println(c);
		}
	}

	public static void main(String[] args) {
		
	}
}