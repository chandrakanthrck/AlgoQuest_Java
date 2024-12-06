package doordash.stack;

import java.util.Stack;

public class BasicCalculatorIII {
    public int calculate(String s) {
        return evaluateExpression(s.toCharArray(), new int[]{0});
    }

    private int evaluateExpression(char[] chars, int[] index) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char operator = '+';

        while (index[0] < chars.length) {
            char c = chars[index[0]];

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0'); // Build the current number
            }

            if (c == '(') {
                index[0]++; // Skip the '('
                num = evaluateExpression(chars, index); // Recursively evaluate
            }

            // Handle operators or end of expression
            if (!Character.isDigit(c) && c != ' ' || index[0] == chars.length - 1) {
                if (operator == '+') {
                    stack.push(num);
                } else if (operator == '-') {
                    stack.push(-num);
                } else if (operator == '*') {
                    stack.push(stack.pop() * num);
                } else if (operator == '/') {
                    stack.push(stack.pop() / num);
                }

                operator = c;
                num = 0; // Reset the number
            }

            if (c == ')') {
                index[0]++; // Skip the ')'
                break;
            }

            index[0]++;
        }

        // Sum up all values in the stack
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }
}

