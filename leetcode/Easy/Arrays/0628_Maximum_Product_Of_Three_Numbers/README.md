# Maximum Product of Three Numbers

## Metadata
![Difficulty: Easy](https://img.shields.io/badge/Difficulty-Easy-brightgreen?style=flat-square)
[![Topic: Array](https://img.shields.io/badge/Topic-Array-blue?style=flat-square)](https://leetcode.com/tag/array/) [![Topic: Math](https://img.shields.io/badge/Topic-Math-blue?style=flat-square)](https://leetcode.com/tag/math/) [![Topic: Sorting](https://img.shields.io/badge/Topic-Sorting-blue?style=flat-square)](https://leetcode.com/tag/sorting/)

- **LeetCode Link**: [https://leetcode.com/problems/maximum-product-of-three-numbers/](https://leetcode.com/problems/maximum-product-of-three-numbers/)
- **Problem ID**: 628
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
    public int maximumProduct(int[] A) {
        int a = -1001, b = a, c = b;
        int x =  1001, y = x;

        for (int n : A) {
            int pa = a, pb = b, px = x;
            
            a = Math.max(a, n);
            b = Math.max(b, Math.min(pa, n));
            c = Math.max(c, Math.min(pb, n));
            
            x = Math.min(x, n);
            y = Math.min(y, Math.max(px, n));
        }

        return Math.max(a * b * c, a * x * y);
    }
}
```
