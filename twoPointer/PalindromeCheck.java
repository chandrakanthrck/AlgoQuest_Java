package twoPointer;

/*
Problem Statement: Check if a given string is a palindrome, considering only alphanumeric characters and ignoring cases.
How to Approach
Use two pointers—one starting at the beginning (left) and the other at the end (right).
Compare characters and move the pointers inward until they meet.
 */
public class PalindromeCheck {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        boolean result = isPalindrome(s);
        System.out.println("Is Palindrome: " + result);
    }

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while(left<right){
            while(left<right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            while(left<right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            if(Character.isLowerCase(s.charAt(left))!=Character.isLowerCase(s.charAt(right))){
                return false;
            }
        }
        return  true;
    }
}

