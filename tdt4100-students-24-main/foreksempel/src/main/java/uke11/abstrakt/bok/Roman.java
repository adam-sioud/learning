package uke11.abstrakt.bok;

// Roaman arver bok, og har sin egen sjanger. I tillegg har den en forfatter. 
public class Roman extends Bok {

	private String forfatter;
	
	protected Roman(String tittel, int antallSider) {
		super(tittel, antallSider);
	}

	public Roman(String tittel, int antallSider, String forfatter) {
		super(tittel, antallSider);
		this.forfatter = forfatter;
	}

	protected String getSjanger() {
		return "Roman";
	}

	protected String toStringHelper() {
		return "forfatter=" + forfatter + ", " + super.toStringHelper();
	}

}
