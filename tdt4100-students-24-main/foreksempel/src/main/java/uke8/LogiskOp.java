package uke8;

import java.util.function.BinaryOperator;

class Or implements BinaryOperator<Boolean> {
    Boolean apply(T t1, T t2) {
        return t1 && t2;
    }
}

public class LogiskOp {
    BinaryOperator<Boolean> or = (t1, t2) -> t1 && t2;
    
}
