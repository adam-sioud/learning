package uke11.arv.bok;

public class Ordbok extends Bok{
    
    int antallOrd;

    public Ordbok() {
        super(); // Ikke nødvendig å kalle super her
    }

    public Ordbok(String tittel, int antallOrd) {
        super(tittel);
        this.antallOrd = antallOrd;
    }

    public void setAntallOrd(int antallOrd) {
        this.antallOrd = antallOrd;
    }

    public int getAntallOrd() {
        return antallOrd;
    }
    
    // Skygger over Bok.getToStringAttributes(), men bruker den!
    protected String getToStringAttributes() {
		return super.getToStringAttributes() + ", antallOrd=" + antallOrd;
	}

    @Override
    public void setTittel(String tittel) {
        System.out.println("OB.setTittel");
        if (!isValidTittel(tittel))
            throw new IllegalArgumentException("må slutte på ordbok");
        super.setTittel(tittel);
    }

    @Override
    public boolean isValidTittel(String tittel) {
        System.out.println("OB.isValidTitle");
        if (!super.isValidTittel(tittel)) {
            return false;
        }
        return tittel.endsWith("ordbok");
    }

    public static void main(String[] args) {
        
        // Her tillater jeg faktisk at tittel kan settes til null. Er jo ikke helt topp
        Bok bok = new Ordbok(); 
        System.out.println(bok); // Hvordan finner den ut hva den skal skrive her?
        
        bok.setTittel("Lawrence of Arabia ordbok"); // Fjern ordbok og kjør.
        // Som du ser bryter vi her Liskovs substitusjonsprinsipp!
        System.out.println(bok); // Hvordan finner den ut hva den skal skrive her?

        Ordbok ordbok = new Ordbok("Nynorsk ordbok", 654);
        System.out.println(ordbok); 

    }
}
