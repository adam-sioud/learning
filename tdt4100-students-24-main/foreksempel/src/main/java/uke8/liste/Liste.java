package uke8.liste;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Liste {

	public static void main(String[] args) {
		List<Integer> liste = new ArrayList<>();
		liste.add(23);
		liste.add(2);
		liste.add(55);

		for (int i = 0; i < liste.size(); i++) {
			int j = liste.get(i);
			System.out.println(j);
		}


		// Hva om en ønsker å bare gå igjennom alle elementene, men ikke bryr seg om
		// hvilken plass de har? Eller om en bruker en Collection, som ikke har .get(i)?
		// Foreach

		// Legg merke til at denne for-løkken ikke har noen 'hva gjør jeg ved neste iterasjon'
		// Dette er siden .next() dytter pekeren fremover, vi trenger ikke gjøre det en gang til. 
		for (Iterator<Integer> iterator = liste.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			System.out.println("tall: "+integer*2);
		}
		
		// Denne prosessen kan forenkles til denne:
		// for (Integer integer : liste) {
		// 	System.out.println(integer*integer);
		// }

	}
}