package of0.lf.oving0;

public class If {
    public static void main(String[] args) {
        int x = 3;
        int y = 11;

        if (x > 5 && y < 10) {
            System.out.println("x er større enn 5 og y er mindre enn 10");
        } else if (x > 5 || y < 10) {
            System.out.println("x er større enn 5 eller y er mindre enn 10");
        } else {
            System.out.println("x er mindre enn 5 og y er større enn 10");
        }
    }
}
