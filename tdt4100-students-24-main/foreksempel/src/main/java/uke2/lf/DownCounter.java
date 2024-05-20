package uke2.lf;

public class DownCounter {
    int counter;

    public DownCounter(int counter){
        this.counter = counter;
    }
    
    public DownCounter() {

    }

    public boolean isFinished() {
        return counter == 0; //primitiv type, så vi tester likhet som tall
    }

    public void countDown() {
        if (counter > 0) {
            counter -= 1;
        }
    }

    public int getCounter() {
        return counter;
    }

    public static void main(String[] args) {
        
        DownCounter dc = new DownCounter(4);
        DownCounter dc2 = new DownCounter(10);
        for (int i = 0; i < 5; i++) {
            System.out.println(dc.isFinished());
            dc.countDown();
        }
        System.out.println(dc2.isFinished());

        DownCounter dc3 = new DownCounter();
        System.out.println(dc3.getCounter());

       
    }
}
