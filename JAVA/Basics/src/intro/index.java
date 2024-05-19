package intro;

public class index {
    public static void main(String[] args) {
        // some primitives, examples
        char ticker = 'a';
        int price = 130;

        // non primitive, example
        String stockName = "Apple";

        // print out example
        System.out.println("Stock " + stockName + " with ticker " + ticker + " has a price of " + price );


        stocks apple = new stocks();
        apple.name = "apple";
        apple.price = 123;

        System.out.println(apple.name);


    }
}
