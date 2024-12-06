package doordash.stack;

/*
556. Next Greater Element III
Given a positive integer n, find the smallest integer which has exactly the same digits existing in the integer n
and is greater in value than n. If no such positive integer exists, return -1.

Note that the returned integer should fit in 32-bit integer, if there is a valid answer but it does not
fit in 32-bit integer, return -1.

 Example 1:
Input: n = 12
Output: 21
Example 2:
Input: n = 21
Output: -1
Constraints:
1 <= n <= 231 - 1
Explanation:
Approach
Convert the number to a list of digits:
Since we need to manipulate individual digits, convert the integer n into a character array.
Find the first decreasing digit from the right:
Traverse the digits from right to left to find the first digit that is smaller than the digit to its right. Let this index be i.
Find the smallest digit greater than digits[i] to its right:
From the digits to the right of i, find the smallest digit that is larger than digits[i]. Let this index be j.
Swap digits[i] and digits[j]:
Swap these two digits to make the number slightly larger.
Reverse the digits to the right of i:
To ensure the number is the smallest possible value larger than n, reverse all digits to the right of index i.
Convert the array back to an integer:
Convert the character array back to an integer and check if it fits in a 32-bit integer.
Return the result:
If the resulting number fits in a 32-bit integer, return it; otherwise, return -1.
 */
public class NextGreaterElement {
    public int nextGreaterElement(int n) {
        char[] digits = String.valueOf(n).toCharArray(); // Convert number to character array
        int len = digits.length;

        // Step 1: Find the first decreasing digit from the right
        int i = len - 2;
        while (i >= 0 && digits[i] >= digits[i + 1]) {
            i--;
        }

        // If no such digit is found, the number is the largest permutation
        if (i < 0) {
            return -1;
        }

        // Step 2: Find the smallest digit larger than digits[i] to its right
        int j = len - 1;
        while (digits[j] <= digits[i]) {
            j--;
        }

        // Step 3: Swap digits[i] and digits[j]
        swap(digits, i, j);

        // Step 4: Reverse the digits to the right of index i
        reverse(digits, i + 1, len - 1);

        // Step 5: Convert the character array back to an integer
        long result = Long.parseLong(new String(digits));
        return (result <= Integer.MAX_VALUE) ? (int) result : -1;
    }

    private void swap(char[] digits, int i, int j) {
        char temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;
    }

    private void reverse(char[] digits, int start, int end) {
        while (start < end) {
            swap(digits, start, end);
            start++;
            end--;
        }
    }
}

/*
Explanation with Examples
Example 1:
plaintext
Copy code
Input: n = 12
Convert n to digits: digits = ['1', '2'].
Find the first decreasing digit from the right: i = 0 (1 < 2).
Find the smallest digit larger than digits[i]: j = 1.
Swap digits[i] and digits[j]: digits = ['2', '1'].
Reverse the digits to the right of i: No need, as there's only one digit to the right.
Result: 21.
Output:

plaintext
Copy code
21
 */