package uke7.personinterface;

public class BrukPerson {
    
    public static void main(String[] args) {
        Person p1 = new Person1();
        p1.setFulltnavn("Per Hansen");
        System.out.println(p1.getFulltnavn());
        System.out.println(p1.getFornavn());
        Person p2 = new Person2();
        p2.setFulltnavn("Per Hansen");
        System.out.println(p2.getFulltnavn());
        System.out.println(p2.getFornavn());
    }
}
