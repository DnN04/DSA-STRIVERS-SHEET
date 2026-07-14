# Sequential Digits

## Metadata
![Difficulty: Medium](https://img.shields.io/badge/Difficulty-Medium-orange?style=flat-square)
[![Topic: Enumeration](https://img.shields.io/badge/Topic-Enumeration-blue?style=flat-square)](https://leetcode.com/tag/enumeration/)

- **LeetCode Link**: [https://leetcode.com/problems/sequential-digits/](https://leetcode.com/problems/sequential-digits/)
- **Problem ID**: 1212
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
    static final int[] q = new int[45];

    static {
        int n = 0;

        for (int i = 1; i < 10; i++)
            q[n++] = i;

        for (int i = 0; i < n; i++) {
            int d = q[i] % 10;

            if (d < 9) 
                q[n++] = q[i] * 10 + d + 1;
        }
    }

    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();

        for (int x : q)
            if (x >= low && x <= high)
                res.add(x);

        return res;
    }
}
```
