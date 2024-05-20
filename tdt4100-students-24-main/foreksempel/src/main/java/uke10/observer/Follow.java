package uke10.observer;

public class Follow implements IFollow{
    
    String hairColour;
    int hairLength;

    public int getHairLength() {
        return hairLength;
    }

    public void setHairLength(int hairLength) {
        this.hairLength = hairLength;
    }

    public void setHairColour(String hairColour) {
        this.hairColour = hairColour;
    }

    public String getHairColour() {
        return hairColour;
    }

    @Override
    public void statusUpdated(Mekker m, String what) {
        if (what.equals("colour")) {
            this.setHairColour(m.getHairColour());
        }
    }

    @Override
    public String toString() {
        return "Follow [hairColour=" + hairColour + ", hairLength=" + hairLength + "]";
    }

    
}
