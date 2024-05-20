package of3.kode;

import java.util.Objects;

/**
 * Klasse som representerer en vare man kan handle i butikken.
 */
public class Item {

    private static final String NUMBERS = "0123456789";

    private String name;
    private double price;
    private String category;
    private String barcode;

    /**
     * Metode som genererer en tilfeldig strekkode for en vare.
     * 
     * @return En tilfeldig strekkode.
     */
    public static String generateBarCode() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 13; i++) {
            sb.append(NUMBERS.charAt((int) (Math.random() * NUMBERS.length())));
        }

        return sb.toString();
    }

    /**
     * Konstruktør for å lage en ny vare, og genererer en tilfeldig strekkode.
     * 
     * @param name     Navnet på varen.
     * @param price    Prisen på varen. Må være større enn 0.
     * @param category Kategorien varen tilhører.
     */
    public Item(String name, double price, String category) {
        this(name, price, category, generateBarCode());
    }

    /**
     * Konstruktør for å lage en ny vare.
     * 
     * @param name     Navnet på varen.
     * @param price    Prisen på varen. Må være større enn 0.
     * @param category Kategorien varen tilhører.
     * @param barcode  Strekkoden til varen. Må være 13 tegn lang.
     */
    public Item(String name, double price, String category, String barcode) {
        if (price < 0) {
            throw new IllegalArgumentException("Price can not be below 0");
        }

        if (barcode == null || barcode.length() != 13) {
            throw new IllegalArgumentException("Invalid bar code");
        }

        // Objects#requireNonNull() er en metode som kaster en NullPointerException om
        // objektet er null, som er ugyldig her.
        this.name = Objects.requireNonNull(name);
        this.price = price;
        this.category = Objects.requireNonNull(category);
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = Objects.requireNonNull(name);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price can not be below 0");
        }

        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = Objects.requireNonNull(category);
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = Objects.requireNonNull(barcode);
    }

    /*
     * Denne metoden lar oss definere hva vi betrakter som et objekt som er likt
     * dette. Vi så tidligere at vi måtte bruke #equals() når vi sammenlignet
     * strenger. På samme måte kan vi bruke dette for å sammenligne andre objekter.
     * Som standard er #equals() implementert på samme måte som ==, men ved å
     * overskrive denne metoden kan vi definere denne logikken selv. Vi kan si at
     * alle Items er like om vi vil, ved å bare returnere true uansett! Dette er
     * selvfølgelig ikke veldig nyttig, men poenget er at vi har full kontroll over
     * hvilke Items som er
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Item item = (Item) o;
        return Double.compare(item.getPrice(), getPrice()) == 0
                && Objects.equals(getName(), item.getName())
                && Objects.equals(getCategory(), item.getCategory())
                && Objects.equals(getBarcode(), item.getBarcode());
    }

    /*
     * Ikke tenk mye på denne metoden. Det er en standardmetode alle objekter har på
     * samme måte som #toString(). Denne er også autogenerert. #hashCode() brukes
     * til å rask regne ut et tall som er unikt for verdiene i denne instansen. Det
     * vil si at dersom 2 instanser har samme verdier har de samme hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPrice(), getCategory(), getBarcode());
    }

    @Override
    public String toString() {
        return "Item [name=" + name + ", price=" + price + ", category=" + category + ", barcode=" + barcode + "]";
    }
}
