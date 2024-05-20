package uke2.lf;

public class Average {

    private double sum = 0;
    private int antall = 0;

    public Average() {

    }

    public Average(double sum, int antall) {
        this.sum = sum;
        this.antall = antall;
    }

    public void acceptValue(double verdi) {
        this.sum += verdi;
        this.antall += 1;
    }

    public double getAverage() {
        return sum/antall;
    }

    public static void main(String[] args) {
        Average avg = new Average();
        System.out.println(avg.getAverage());


        avg.acceptValue(2.0);
        System.out.println(avg.getAverage());

        Average avg2 = new Average(10.0, 1);
        System.out.println(avg2.getAverage());
        avg2.acceptValue(21);
        System.out.println(avg2.getAverage());
    }
    
}
