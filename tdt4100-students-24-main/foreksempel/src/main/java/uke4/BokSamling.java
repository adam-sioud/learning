package uke4;

import java.util.ArrayList;
import java.util.List;

public class BokSamling {
    private String navn;
    private int maxAntallBøker;
    private List<Bok> books = new ArrayList<>();

    public BokSamling(String navn, int maxAntallBøker) {
        //todo: Legg til gyldighetssjekker
        this.navn = navn;
        this.maxAntallBøker = maxAntallBøker;
    }

    //Hvilke metoder og synlighetsmodifikatorer skal vi ha for å ivareta innkapsling?
    public void addBook(Bok bok) {
        if (bok == null) {
            throw new NullPointerException();
        }
        if (books.size() >= maxAntallBøker) {
            throw new IllegalStateException();
        }
        books.add(bok);
    }

    public void removeBook(Bok bok) {
        // fjerner første forekomst av bok i books-listen,
        // dvs. første bok som er lik ved bruk at equals-metoden.
        books.remove(bok);
        
    }

    public String getNavn() {
        return navn;
    }
    
    public boolean harBok(Bok bok) {
        return books.indexOf(bok) != -1;
    }

    public Bok finnBok(String delAvTittel) {
        for (Bok bok : books) {
            if (bok.getTittel().contains(delAvTittel)) {
                return bok;
            }
        }
        return null; // NB! Dette vil vi senere finne en bedre løsning på
    }

    public static void main(String[] args) {
        BokSamling myBooks = new BokSamling("Skjønnlitteratur", 3);

        //Lager et bok-objekt
        Bok maskinerTenker = new Bok("Maskiner som tenker", 200);
        System.out.println(maskinerTenker.getTittel());
        maskinerTenker.setBokmerke(10);
        System.out.println(maskinerTenker.isStarted());
        maskinerTenker.addReadPages(50);

        //Legger boka til samlingen:
        myBooks.addBook(maskinerTenker);
        myBooks.addBook(new Bok("Java 1", 300));

        Bok javaBok = myBooks.finnBok("ava");
        System.out.println(javaBok);

        //Dette kan vi ikke gjøre i andre klasser, hvis books er private


        


    }
}
