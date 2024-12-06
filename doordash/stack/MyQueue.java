package doordash.stack;

import java.util.Stack;

public class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        // Push element onto stack1
        stack1.push(x);
    }

    public int pop() {
        // Ensure stack2 has the current front
        if (stack2.isEmpty()) {
            transferStack1ToStack2();
        }
        return stack2.pop(); // Pop from stack2
    }

    public int peek() {
        // Ensure stack2 has the current front
        if (stack2.isEmpty()) {
            transferStack1ToStack2();
        }
        return stack2.peek(); // Peek from stack2
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    private void transferStack1ToStack2() {
        // Transfer elements from stack1 to stack2
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        queue.push(1);
        queue.push(2);
        System.out.println("Peek: " + queue.peek());   // Output: 1
        System.out.println("Pop: " + queue.pop());     // Output: 1
        System.out.println("Empty: " + queue.empty()); // Output: false
    }
}
