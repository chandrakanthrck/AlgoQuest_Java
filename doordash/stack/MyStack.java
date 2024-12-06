package doordash.stack;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        // Enqueue the new element into queue2
        queue2.offer(x);
        // Transfer all elements from queue1 to queue2
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        // Swap queues
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public int pop() {
        // Pop from queue1 (top of the stack)
        return queue1.poll();
    }

    public int top() {
        // Peek the front of queue1 (top of the stack)
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();

        stack.push(1);
        stack.push(2);
        System.out.println("Top: " + stack.top());   // Output: 2
        System.out.println("Pop: " + stack.pop());   // Output: 2
        System.out.println("Empty: " + stack.empty()); // Output: false
    }
}
