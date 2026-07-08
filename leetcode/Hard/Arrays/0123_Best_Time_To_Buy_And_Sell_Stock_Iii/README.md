# Best Time to Buy and Sell Stock III

## Metadata
![Difficulty: Hard](https://img.shields.io/badge/Difficulty-Hard-red?style=flat-square)
[![Topic: Array](https://img.shields.io/badge/Topic-Array-blue?style=flat-square)](https://leetcode.com/tag/array/) [![Topic: Dynamic Programming](https://img.shields.io/badge/Topic-Dynamic Programming-blue?style=flat-square)](https://leetcode.com/tag/dynamic-programming/)

- **LeetCode Link**: [https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/)
- **Problem ID**: 123
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
    public int maxProfit(int[] prices) {
        int b1 = Integer.MIN_VALUE, s1 = 0;
        int b2 = Integer.MIN_VALUE, s2 = 0;

        for (int price : prices) {
            b1 = Math.max(b1, - price);
            s1 = Math.max(s1, b1 + price);
            b2 = Math.max(b2, s1 - price);
            s2 = Math.max(s2, b2 + price);
        }
        return s2;
    }
}
```
