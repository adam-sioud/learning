package of0.lf;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>(
                Map.of("Popper", 1902));

        map.put("Platon", -428);
        map.put("Hume", 1711);
        map.put("Aristoteles", -384);
        map.put("Descartes", 1596);

        System.out.println(map.size());
        map.remove("Hume");
        System.out.println(map.size());
    }
}
