package fastAndSlowPointer;

/*Problem Statement: A number is called happy if it eventually reaches 1 when replaced by the sum of the square
 of its digits. If it loops endlessly in a cycle that does not include 1, it's not a happy number.
 Determine if a given number is happy.

Approach:
Use a slow pointer to follow the sum of squares one step at a time, and a fast pointer that calculates
the sum of squares two steps at a time.
If both pointers meet at a value other than 1, there is a cycle, and the number is not happy.

 */
public class HappyNumber {
    public static boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = findSquareSum(slow);  // Move slow pointer one step
            fast = findSquareSum(findSquareSum(fast));  // Move fast pointer two steps
        } while (slow != fast);  // If they meet, a cycle is detected

        return slow == 1;  // Check if the cycle includes 1 (happy number)
    }

    private static int findSquareSum(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));  // Output: true
        System.out.println(isHappy(2));   // Output: false
    }
}