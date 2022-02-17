package solutions.quiz;

import java.util.ArrayList;

public class StackSim {

    private static class XStack {
        ArrayList<Integer> content = new ArrayList<>();
        int sum = 0;

        void push(int x) {
            content.add(x);
        }

        void pop() {
            if (content.size() > 0)
            content.remove(content.size() - 1);
        }

        void top() {
            if (content.size() > 0)
                sum = sum + content.get(content.size() - 1);
        }
    }

    public static void main(String[] args) {
        XStack xStack = new XStack();
        xStack.push(5);
        xStack.push(2);
        xStack.top();
        xStack.pop();
        xStack.top();
        xStack.pop();
        xStack.top();
        xStack.push(7);
        xStack.top();
        System.out.println(xStack.sum);
    }

}
