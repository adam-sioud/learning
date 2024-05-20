package uke3;

public class RekursivObjekt {

    int n;
    RekursivObjekt next;
    
    public RekursivObjekt(int n) {
        this.n = n;
        if (n > 0) {
            this.next = new RekursivObjekt(n-1);
        }
    }


    public void print() {
        // En rekursiv funksjon som printer
        System.out.print(n);
        if (next != null) {
            System.out.print("->");
            next.print();
        }
    }

    public static void main(String[] args) {
        
        RekursivObjekt rekObj = new RekursivObjekt(3);
        
        rekObj.print();
    }
}
