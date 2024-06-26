package uke9.iostreams;

import java.io.Serializable;

public class Dyr implements Serializable{

	private static final long serialVersionUID = 1L;

	String type;
	String lyd;
	int bein;

	public Dyr(String type, String lyd, int bein) {
		super();
		this.type = type;
		this.lyd = lyd;
		this.bein = bein;
	}

	@Override
	public String toString() {
		return type + " sier " + lyd + " og har " + bein + " bein.";
	}
	
}
