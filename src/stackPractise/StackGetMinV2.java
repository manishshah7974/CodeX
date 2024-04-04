package stackPractise;

import java.util.Stack;

public class StackGetMinV2 {
    static Stack<Integer> aux = new Stack<>();

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        pushElement(s, 20);
        pushElement(s, 10);
        System.out.println(getMin());
        pushElement(s, 5);
        System.out.println(getMin());
        popElement(s);
        System.out.println(getMin());
        popElement(s);
        System.out.println(getMin());
        popElement(s);
    }

    public static void pushElement(Stack<Integer> s, int element) {
        s.push(element);
        updateMinValue(element);
    }

    public static void popElement(Stack<Integer> s) {
        int currentElement = s.peek();
        s.pop();
        if (!aux.isEmpty() && currentElement == aux.peek()) {
            aux.pop();
        }

    }

    public static int getMin() {
        return aux.peek();
    }

    public static void updateMinValue(int tmp) {
        if (aux.isEmpty())
            aux.push(tmp);
        else if (tmp < aux.peek()) {
            aux.push(tmp);
        }
    }

}
