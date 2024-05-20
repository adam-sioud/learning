package uke4;

public class Bok {
    /* Denne klassen brukes for å holde orden på hvor langt en har lest i en bok */
    
    //todo: Legg til synlighetsmodifikatorer for innkapsling
    private String tittel;
    private int antallSider;
    private int bokmerke;

    public int getBokmerke() {
        return bokmerke;
    }

    Bok(String tittel, int antallSider) {
        
        //todo: Legg til validering
        if (tittel == null) {
            throw new NullPointerException("Tittel kan ikke være null");
        }
        if (antallSider <= 0) {
            throw new IllegalArgumentException("Boka må ha positivt antall sider");
        }

        this.tittel = tittel;
        this.antallSider = antallSider;
        this.bokmerke = 0;      //Streng tatt ikke nødvendig, men bedre å være tydelig!
    }

    //todo: Set-metoder for å endre tilstand på bokmerke
    void setBokmerke(int bokmerke) {
        if (bokmerke < 0 || bokmerke > antallSider) {
            throw new IllegalArgumentException("Bokmerke må være mellom 0 og antall sider");
        }
        this.bokmerke = bokmerke;
    }

    //todo: Get-metoder for å hente verdier fordi de ikke får lov å endres direkte
    public String getTittel() {
        return this.tittel; //her trenger vi ikke this...
    }
    public int getAntallSider() {
        return antallSider;
    }
    

    //todo: Andre nyttige metoder? 
    public boolean isStarted() {
        return bokmerke > 0;
    }

    public void addReadPages(int sider) {
        // Her har vi valgt å være "strenge", dvs. at unntak utløses
        // Alternativt kan vi sette at alle sider er lest 
        if (sider + bokmerke > antallSider) {
            throw new IllegalArgumentException("Lest flere sider som er igjen");
        }
        bokmerke += sider;
    }


    @Override
    public int hashCode() {  // Denne er generert av VSCode-tillegget via "Source actions..."
        final int prime = 31;
        int result = 1;
        result = prime * result + ((tittel == null) ? 0 : tittel.hashCode());
        result = prime * result + antallSider;
        return result;
    }

    @Override
    public boolean equals(Object obj) { // Denne er generert av VSCode-tillegget via "Source actions..."
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Bok other = (Bok) obj;
        if (tittel == null) {
            if (other.tittel != null)
                return false;
        } else if (!tittel.equals(other.tittel))
            return false;
        if (antallSider != other.antallSider)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Bok [tittel=" + tittel + ", antallSider=" + antallSider + "]";
    }

    static public void main(String[] args) {
        // NB! Denne metoden (main) tilhører klassen, så alle felt er synlige, uansett modifikatorer
        // likevel bruker vi tilgangsmetodene (get/set) 

        // Først test av validering i konstruktøren
        Bok tomBok, tt, krigBok, javaBok, maskinerTenker;
        try {
             tt = new Bok("Tommy og Tigern", 10);
             krigBok = new Bok("Krig og fred", 500);
             javaBok = new Bok("Big Java", 400);
             maskinerTenker = new Bok("Maskiner som tenker", 309);
             tomBok = new Bok(null, 10);
        }
        catch (IllegalArgumentException e) {
            System.out.println("Illegal " + e.getMessage());
        }
        catch (Exception e) {
            // Alle unntak som ikke allerede er håndtert over
            System.out.println(e.getMessage());
        }
        
        finally {
            // Uføres uansett, også hvis unntak ikke håndteres av en catch-blokk over
            System.out.println("Hit kommer vi okke som");
        }
        
        // Vi har definert equals (og kompatibel hashCode),
        System.out.println(new Bok("Hei", 10));        

        Bok bok1 = new Bok("hei", 10);
        Bok bok2 = new Bok("hei", 10);

        System.out.println(bok1 == bok2);       // forksjellige objekter, derfor false
        System.out.println(bok1.equals(bok2));  // likt innhold, derfor true i henhold til equals-metoden

        // Hash-kodene blir like pga likt innhold, i tråd med equals-metoden.
        System.out.println("bok1.hashCode() = " + bok1.hashCode() + ", bok2.hashCode() = " + bok2.hashCode());
        
    }

}
