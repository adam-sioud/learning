package uke10.observer;

import java.util.Random;

public class Person {
    
    Random random = new Random();
    Follower follower;

    public void setFollower(Follower follower) {
        this.follower = follower;
    }

    public void siEtTall(){
        int tall = random.nextInt(100);
        System.out.println("Jeg sier "+tall);
        follower.personHarSagt(tall);
    }

    public static void main(String[] args) {
        Person p = new Person();
        p.setFollower(new Follower());
        p.siEtTall();
    }
}
