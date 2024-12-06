package doordash.simulation;

import java.util.Stack;

public class BasicCalculatorII {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0; // Current number
        char operator = '+'; // Current operator, default to '+'

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0'); // Build the number
            }

            // Process operators or end of string
            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
                if (operator == '+') {
                    stack.push(num);
                } else if (operator == '-') {
                    stack.push(-num);
                } else if (operator == '*') {
                    stack.push(stack.pop() * num);
                } else if (operator == '/') {
                    stack.push(stack.pop() / num);
                }

                operator = c; // Update operator
                num = 0; // Reset number
            }
        }

        // Sum up all numbers in the stack
        int result = 0;
        for (int value : stack) {
            result += value;
        }

        return result;
    }

    public static void main(String[] args) {
        BasicCalculatorII solution = new BasicCalculatorII();

        System.out.println(solution.calculate("3+2*2")); // Output: 7
        System.out.println(solution.calculate(" 3/2 ")); // Output: 1
        System.out.println(solution.calculate(" 3+5 / 2 ")); // Output: 5
    }
}

