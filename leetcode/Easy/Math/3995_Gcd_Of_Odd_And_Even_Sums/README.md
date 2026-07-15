# GCD of Odd and Even Sums

## Metadata
![Difficulty: Easy](https://img.shields.io/badge/Difficulty-Easy-brightgreen?style=flat-square)
[![Topic: Math](https://img.shields.io/badge/Topic-Math-blue?style=flat-square)](https://leetcode.com/tag/math/) [![Topic: Number Theory](https://img.shields.io/badge/Topic-Number Theory-blue?style=flat-square)](https://leetcode.com/tag/number-theory/)

- **LeetCode Link**: [https://leetcode.com/problems/gcd-of-odd-and-even-sums/](https://leetcode.com/problems/gcd-of-odd-and-even-sums/)
- **Problem ID**: 3995
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

    private int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }

    public int gcdOfOddEvenSums(int n) {
        return gcd(n * n, n * (n + 1));
    }
}
```
