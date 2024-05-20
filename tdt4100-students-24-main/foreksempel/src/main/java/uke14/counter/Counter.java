package uke14.counter;

public class Counter {
    private int count;
    private int max;

    public Counter(int max) {
        if (max < 0)
            throw new IllegalArgumentException("Max must be non-negative"); 
        this.max = max;
        count = 0;
    }

    public int getCount() {
        return count;
    }

    public void count() {
        if (count < max)
            count++;
    }

    public boolean isMax() {
        return count >= max;
    }
}
