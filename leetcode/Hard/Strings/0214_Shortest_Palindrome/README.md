# Shortest Palindrome

## Metadata
![Difficulty: Hard](https://img.shields.io/badge/Difficulty-Hard-red?style=flat-square)
[![Topic: String](https://img.shields.io/badge/Topic-String-blue?style=flat-square)](https://leetcode.com/tag/string/) [![Topic: Rolling Hash](https://img.shields.io/badge/Topic-Rolling Hash-blue?style=flat-square)](https://leetcode.com/tag/rolling-hash/) [![Topic: String Matching](https://img.shields.io/badge/Topic-String Matching-blue?style=flat-square)](https://leetcode.com/tag/string-matching/) [![Topic: Hash Function](https://img.shields.io/badge/Topic-Hash Function-blue?style=flat-square)](https://leetcode.com/tag/hash-function/)

- **LeetCode Link**: [https://leetcode.com/problems/shortest-palindrome/](https://leetcode.com/problems/shortest-palindrome/)
- **Problem ID**: 214
- **Language**: Java

## Solution Design

### Method Explanation
- *We solve this problem by leveraging standard data structures or algorithms suitable for the problem constraints.*
- *Make sure to update this section with notes on your implementation approaches.*

### Complexity Analysis
- **Time Complexity**: \(O(N)\) (where \(N\) is the number of elements)
- **Space Complexity**: \(O(1)\) auxiliary space

## Solution Code

```java
class Solution {

    public String shortestPalindrome(String s) {
        int length = s.length();
        String reversedString = new StringBuilder(s).reverse().toString();

        // Iterate through the string to find the longest palindromic prefix
        for (int i = 0; i < length; i++) {
            if (
                s.substring(0, length - i).equals(reversedString.substring(i))
            ) {
                return new StringBuilder(reversedString.substring(0, i))
                    .append(s)
                    .toString();
            }
        }
        return "";
    }
}
```
