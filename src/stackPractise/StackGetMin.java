package stackPractise;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class StackGetMin {
    static Integer minValue = Integer.MAX_VALUE;

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
    //  20 , 10 , 5
    //  20 ,10 , 5 ,

    public static void pushElement(Stack<Integer> s, int element) {
        s.push(element);
        updateMinValue(element);
    }

    public static void popElement(Stack<Integer> s) {
        int currentElement = s.peek();
        s.pop();
        if (currentElement == getMin() && !s.isEmpty()) {
            ArrayList<Integer> X = new ArrayList<>(s);
            Iterator<Integer> i = X.iterator();
            minValue = i.next();
            while (i.hasNext()) {
                int tmp = i.next();
                if (minValue > tmp)
                    minValue = tmp;
            }
        }

    }

    public static int getMin() {
        return minValue;
    }

    public static void updateMinValue(int tmp) {
        if (tmp < minValue) minValue = tmp;
    }

}
