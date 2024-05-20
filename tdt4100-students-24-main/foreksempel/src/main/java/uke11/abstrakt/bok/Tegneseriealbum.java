package uke11.abstrakt.bok;

// Denne klassen arver bare Bok, og definerer en sjanger. Ikke noe mer spennende.
public class Tegneseriealbum extends Bok {

	public Tegneseriealbum(String tittel, int antallSider) {
		super(tittel, antallSider);
	}

	@Override
	protected String getSjanger() {
		return "Tegneseriealbum";
	}

	public static void main(String[] args) {
		var roman = new Roman("Kurt koker hodet", 65); // Her støtter vi dog at forfatter er null... 
		System.out.println(roman);
		var roman2 = new Roman("Kurt koker hodet", 65, "Erlend Loe");
		System.out.println(roman2);

		Bok bøk = new Bok("En anonym bok", 100) {
			@Override
			protected String getSjanger() {
				return "Ukjent sjanger";
			}
		};

		Bok bok = new Tegneseriealbum("Maus", 295);
		System.out.println(bok);
	}


}
