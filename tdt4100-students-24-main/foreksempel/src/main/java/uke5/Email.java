package uke5;

public class Email {
    private String name;
    private String domain;

    public Email(String name, String domain) {
        if (!validateEmail(name, domain)) {
            throw new IllegalArgumentException();
        }
       this.name = name;
       this.domain = domain;
    }

    // Java krever at kall til annen konstruktør må gjøres som første kodelinje 
    // Dette kan løses på flere måter, her velger vi å 
    // lage egen valideringsfunksjon. Den kan være static
    public Email(String email) {
        String[] email_split = email.split("@");
        if (email_split.length != 2) {
            throw new IllegalArgumentException("Epost må inneholde nøyaktig en @");
        }
        if (! validateEmail(email_split[0], email_split[1])) {
            throw new IllegalArgumentException();
        }
    }
    
    public static boolean validateEmail(String name, String domain) {
        // Sjekk at epost er gyldig. Dette er en veldig forenkling av test.
        // En kan slå sammen testene til en if-setning, hvis en ønsker
        if (name == null || domain == null) {
            return false;
        }
        if (name.length() == 0) {
            return false;
        }
        if (!domain.contains(".")) {
            return false;
       }
       return true;
    }

    @Override
    public String toString() {
        return name + "@" + domain;
    }


    public static void main(String[] args) {
        Email e1 = new Email("yes", "maybe.no");
        System.out.println(e1);

    }
}
