package doordash.trie;
/*
Search Suggestions System
You are given an array of strings products and a string searchWord.
Design a system that suggests at most three product names from products after each character of searchWord is typed.
Suggested products should have common prefix with searchWord. If there are more than three products with a common prefix
return the three lexicographically minimums products.
Return a list of lists of the suggested products after each character of searchWord is typed.
Example 1:

Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
Output: [["mobile","moneypot","monitor"],["mobile","moneypot","monitor"],["mouse","mousepad"],["mouse",
"mousepad"],["mouse","mousepad"]]
Explanation: products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"].
After typing m and mo all products match and we show user ["mobile","moneypot","monitor"].
After typing mou, mous and mouse the system suggests ["mouse","mousepad"].
Example 2:
Input: products = ["havana"], searchWord = "havana"
Output: [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
Explanation: The only word "havana" will be always suggested while typing the search word.

Constraints:
1 <= products.length <= 1000
1 <= products[i].length <= 3000
1 <= sum(products[i].length) <= 2 * 104
All the strings of products are unique.
products[i] consists of lowercase English letters.
1 <= searchWord.length <= 1000
searchWord consists of lowercase English letters.

The Search Suggestions System problem involves suggesting at most three product names from a sorted list of products
after each character of a search word is typed. Here's an efficient approach to solve the problem:
Approach
Sort the Products:
Start by sorting the products lexicographically. This ensures that the first three matches found are automatically the
smallest in lexicographical order.
Incrementally Build the Search:
For each character typed in searchWord, filter the products to keep only those that start with the current prefix.
Optimize the Filtering:
Instead of scanning the entire list repeatedly, we can use binary search to narrow down the range of matching products.
This makes the filtering efficient.
Limit Suggestions:
After finding the matching products for a prefix, take the first three suggestions (or fewer if there are less than
three matches).
Return Results:
Append the list of suggestions for each prefix to the result list.
 */
import java.util.*;

public class SearchSuggestionSystem {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        // Step 1: Sort the products lexicographically
        Arrays.sort(products);

        List<List<String>> result = new ArrayList<>();
        String prefix = ""; // Incremental prefix built from searchWord

        // Step 2: Process each character in searchWord
        for (char c : searchWord.toCharArray()) {
            prefix += c; // Add the current character to the prefix
            List<String> suggestions = new ArrayList<>();

            // Step 3: Use binary search to find the first product that matches the prefix
            int index = binarySearch(products, prefix);

            // Step 4: Collect up to three matches
            for (int i = index; i < products.length && suggestions.size() < 3; i++) {
                if (products[i].startsWith(prefix)) {
                    suggestions.add(products[i]);
                } else {
                    break; // Stop if a product no longer matches the prefix
                }
            }

            // Step 5: Add suggestions for the current prefix to the result
            result.add(suggestions);
        }

        return result;
    }

    // Helper method: Binary search for the starting position of the prefix
    private int binarySearch(String[] products, String prefix) {
        int low = 0, high = products.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (products[mid].compareTo(prefix) < 0) {
                low = mid + 1; // Move right if the product is lexicographically smaller
            } else {
                high = mid; // Move left otherwise
            }
        }
        return low; // Return the first index where prefix can match
    }
}

/*
Explanation with Example
Input:
products = ["mobile","mouse","moneypot","monitor","mousepad"]
searchWord = "mouse"
Sort Products:
products = ["mobile", "moneypot", "monitor", "mouse", "mousepad"]
Prefix Matching:
Prefix: "m":
Binary search finds index 0.
Suggestions: ["mobile", "moneypot", "monitor"].
Prefix: "mo":
Binary search finds index 0.
Suggestions: ["mobile", "moneypot", "monitor"].
Prefix: "mou":
Binary search finds index 3.
Suggestions: ["mouse", "mousepad"].
Prefix: "mous":
Binary search finds index 3.
Suggestions: ["mouse", "mousepad"].
Prefix: "mouse":
Binary search finds index 3.
Suggestions: ["mouse", "mousepad"].
Result:
[["mobile","moneypot","monitor"],["mobile","moneypot","monitor"],
 ["mouse","mousepad"],["mouse","mousepad"],["mouse","mousepad"]]
 */