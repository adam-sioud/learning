package uke7.loekkeinterface;

import java.util.ArrayList;
import java.util.List;

public class Loekker {

	public static void main(String[] args) {
		
		List<Character> liste = new ArrayList<>();
		liste.add('a');
		liste.add('b');
		liste.add('c');		
		
		String streng = new String("def");
		
		char[] charArray = { 'g', 'h', 'i'}; 

		Loekker.skrivut(liste, new ListCharPrinter());
		Loekker.skrivut(streng, new StringCharPrinter());
		Loekker.skrivut(charArray, new CharArrayPrinter());	

		new CharArrayPrinter().printCharacters(charArray);
	}

	private static void skrivut(Object ob, LoekkePrintInterface pI) {
		pI.printCharacters(ob);
	}
}
