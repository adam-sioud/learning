package uke9.streams;

public class Score {
    private String id;
    private int value;

    public Score(String id, int value) {
        this.id = id;
        this.value = value;
    }

    public Score(String id) {
        this.id = id;
        this.value = -1;
    }

    public String getId() {
        return id;
    }
    
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
    @Override
    public String toString() {
        return "Score{" + "id=" + id + ", value=" + value + '}';
    }

}
