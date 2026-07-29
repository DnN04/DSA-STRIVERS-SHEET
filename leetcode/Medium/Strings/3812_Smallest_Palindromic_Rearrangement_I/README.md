# Smallest Palindromic Rearrangement I

## Metadata
![Difficulty: Medium](https://img.shields.io/badge/Difficulty-Medium-orange?style=flat-square)
[![Topic: String](https://img.shields.io/badge/Topic-String-blue?style=flat-square)](https://leetcode.com/tag/string/) [![Topic: Sorting](https://img.shields.io/badge/Topic-Sorting-blue?style=flat-square)](https://leetcode.com/tag/sorting/) [![Topic: Counting Sort](https://img.shields.io/badge/Topic-Counting Sort-blue?style=flat-square)](https://leetcode.com/tag/counting-sort/)

- **LeetCode Link**: [https://leetcode.com/problems/smallest-palindromic-rearrangement-i/](https://leetcode.com/problems/smallest-palindromic-rearrangement-i/)
- **Problem ID**: 3812
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

    public String smallestPalindrome(String s) {
        int len = s.length();
        int partition = len / 2;

        char[] chars = s.toCharArray();
        Arrays.sort(chars, 0, partition);

        for (int i = 0; i < partition; i++) {
            chars[len - 1 - i] = chars[i];
        }

        return new String(chars);
    }
}
```
