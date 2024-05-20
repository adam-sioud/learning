package uke11.abstrakt.bok;

public abstract class Bok {

	private String tittel;
	private int antallSider;
	
	protected Bok(String tittel, int antallSider) {
		this.tittel = tittel;
		this.antallSider = antallSider;
	}
	
	protected String toStringHelper() {
		return "tittel=" + tittel + ", antallSider=" + antallSider;
	}

	@Override
	public String toString() {
		return getSjanger() + "[" + toStringHelper() + "]";
	}

	protected abstract String getSjanger();

	public String getTittel() {
		return tittel;
	}
	
	public int getAntallSider() {
		return antallSider;
	}

	public static void main(String[] args) {
		var roman = new Roman("Kurt koker hodet", 65); // Her støtter vi dog at forfatter er null... 
		System.out.println(roman);
		var roman2 = new Roman("Kurt koker hodet", 65, "Erlend Loe");
		System.out.println(roman2);

		// Bare for å vise at en kan implementere anonyme, indre klasser som
		// implementerer et interface. Ikke ment som 'gjør dette hjemme'
		Bok bok = new Bok("1984", 1948) {

			@Override
			protected String getSjanger() {
				return "skremmende";
			}
			
		};

		Bok bok2 = new Tegneseriealbum("Maus", 295);
		System.out.println(bok2);
	}

}
