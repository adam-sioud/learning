package uke12.simpleRPN;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.List;

public class RpnModel {
    private Deque<Double> stack = new ArrayDeque<>();

    public void push(double value) {
        stack.push(value);
    }

    public void add() {
        performOperation((a, b) -> a + b);
    }
    public void subtract() {
        performOperation((a, b) -> a - b);
    }
    public void multiply() {
        performOperation((a, b) -> a * b);
    }
    public void divide() {
        performOperation((a, b) -> a / b);
    }

    private void performOperation(BinaryOperator<Double> operation) {
        if (stack.size() >= 2) {
            double a = stack.pop();
            double b = stack.pop();
            double result = operation.apply(a, b);
            stack.push(result);
        }
    }

    public List<Double> getStackElements() {
        return stack.stream().collect(Collectors.toList());
    }
}
