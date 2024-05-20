package uke11.liskov;

class BaseLiskov {
    public String say() {
        return "BaseLiskov";
    }
}

public class NotLiskov1 extends BaseLiskov {
    @Override
    public String say() {
        throw new RuntimeException("NotLiskov1");
    }
    
}
