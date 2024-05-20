package uke7.loekkeinterface;

public class StringCharPrinter implements LoekkePrintInterface<String> {

	@Override
	public void printCharacters(String tmp) {
		//
		
		
			for (int i = 0; i < tmp.length(); i++) {
				Character c = tmp.charAt(i);
				System.out.println(c);
			}

		
		
	}

}
