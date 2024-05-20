package uke2.lf;

public class AverageCoordinator {
    Random100 rand100;
    Average avg;
    DownCounter dc;

    public AverageCoordinator() {
        this.rand100 = new Random100();
        this.avg = new Average();
        this.dc = new DownCounter(10);
    }

    public double getAverage() {
        while (!dc.isFinished()) {
            avg.acceptValue(rand100.getRandom100());
            dc.countDown();
        }
        return avg.getAverage();
    }

    public static void main(String[] args) {
        AverageCoordinator ac = new AverageCoordinator();
        System.out.println(ac.getAverage());

    }



}
