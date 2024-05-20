package of0.lf.oving0;

public class Functions {

    public static void main(String[] args) {
        Functions functions = new Functions();

        double result = functions.division(10.0d, 5.0d);
        System.out.println(result);

        int fakultet = functions.fakultet(5);
        System.out.println(fakultet);
    }

    int fakultet(int num) {
        int verdi = 1;

        for (int i = 1; i <= num; i++) {
            verdi *= i;
        }

        return verdi;
    }

    double division(double x, double y) {
        return x / y;
    }
}
