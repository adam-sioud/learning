package uke3;

public class Skop {
    static int b;
    int a;

    public void A(int a) {
        this.a = a;
    }
    
    public void B() {
        System.out.println(a);
        this.a += b;
    }
    public static void main(String[] args) {
        Skop aobj = new Skop();
        aobj.A(3);
        aobj.B();
        System.out.println(b);
        System.out.println(a);

        
    }
}
