package uke3;

import java.util.ArrayList;

public class PasswordList {
    private ArrayList<String> passord = new ArrayList<>();
    private ArrayList<String> konto = new ArrayList<>();

    public void setPassword(String passord, String konto) {
        // Valider passord før det lagres
        if (passord.length() < 8) {
            System.out.println("Passord for kort");
            return;
        }
        this.passord.add(passord);
        this.konto.add(konto);
    }

    public String getPassword(String konto) {
        int idx = this.konto.indexOf(konto);
        if (idx == -1) {
            System.out.println("Passord finnes ikke");
            return "";
        }
        return this.passord.get(idx);
    }

    public void removePassword(String konto) {
        //todo: Finn indeks, og fjern elt fra begge lister
    }

    public static void main(String[] args) {
        PasswordList data = new PasswordList();
        data.setPassword("hei1234567", "GitlAB");

        System.out.println(data.passord);
        System.out.println(data.konto);

        System.out.println(data.getPassword("GitlAB"));

        PasswordList passord = new PasswordList();
        passord.setPassword("123456678hei", "Google");

        System.out.println(passord.getPassword("Gogle"));

    }
}
