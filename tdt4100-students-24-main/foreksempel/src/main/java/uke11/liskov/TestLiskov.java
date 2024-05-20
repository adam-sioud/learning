package uke11.liskov;

public class TestLiskov {
    public static void main(String[] args) {
        BaseLiskov b = new BaseLiskov();
        System.out.println(b.say());

        BaseLiskov c = new NotLiskov1();
        System.out.println(c.say());
    }
}
