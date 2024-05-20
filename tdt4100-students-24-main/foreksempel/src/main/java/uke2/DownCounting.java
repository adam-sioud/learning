package uke2;

public class DownCounting {
    
    static boolean isFinished(int counter) {
        return counter == 0;
    }

    static int countDown(int counter) {
        return counter - 1;
    }

    public static void main(String[] args) {
        int counter = 5;
        while (! isFinished(counter)) {
            counter = countDown(counter);
            System.out.println(counter);
        }


    }
}
