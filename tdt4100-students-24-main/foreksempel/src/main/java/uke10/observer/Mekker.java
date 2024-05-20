package uke10.observer;

import java.util.Collection;

public class Mekker {
    
    String hairColour;
    Collection<Follow> listeners;
    int hairLength;

    private void setColour(String colour) {
        this.hairColour = colour;
        this.updateListeners("colour");
    }

    public void setHairLength(int hairLength) {
        this.hairLength = hairLength;
        this.updateListeners("length");
    }

    public int getHairLength() {
        return hairLength;
    }

    private void updateListeners(String what) {
        this.listeners.forEach(l -> l.statusUpdated(this, what));
    }

    public String getHairColour() {
        return hairColour;
    }

    public void addListener(Follow f) {
        this.listeners.add(f);
    }

    public static void main(String[] args) {
        Mekker m = new Mekker();
        Follow f = new Follow();
        m.addListener(f);
        m.setColour("svart");
        m.setHairLength(23);
        System.out.println(m.getHairColour());
        System.out.println("f: "+f.getHairColour());
        m.setColour("cyan");
        System.out.println(m.getHairColour());
        System.out.println("f: "+f.getHairColour());

    }
}
