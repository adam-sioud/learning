package of0.lf;

import java.util.ArrayList;
import java.util.List;

public class Lister {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("test1");
        list.add("test2");
        list.add("test3");
        
        System.out.println(list.get(1));

        ArrayList<Double> list2 = new ArrayList<>(List.of(2.0, 1.2, 5.0)); 
        System.out.println(list2.size());
    }
}
