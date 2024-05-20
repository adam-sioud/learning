package uke3;

public class KodeblokkErSkop {
    public static void main(String[] args) {

        int i;
        for (i=0; i < 5; i++) {
            System.out.println(i);
        }
        System.out.println(i);

        for (int j=0; j < 5; j++) {
            System.out.print(j);
        }
        
        //System.out.println(j);
    }
}
