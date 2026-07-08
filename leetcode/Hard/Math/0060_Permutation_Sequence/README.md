# Permutation Sequence

## Metadata
![Difficulty: Hard](https://img.shields.io/badge/Difficulty-Hard-red?style=flat-square)
[![Topic: Math](https://img.shields.io/badge/Topic-Math-blue?style=flat-square)](https://leetcode.com/tag/math/) [![Topic: Recursion](https://img.shields.io/badge/Topic-Recursion-blue?style=flat-square)](https://leetcode.com/tag/recursion/)

- **LeetCode Link**: [https://leetcode.com/problems/permutation-sequence/](https://leetcode.com/problems/permutation-sequence/)
- **Problem ID**: 60
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
    public String getPermutation(int n, int k) {
        if(n == 1) return "1";
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) sb.append(i);
        int factorial = 1;
        for(int i = 2; i < n; i++) factorial *= i;
        n--;

        StringBuilder result = new StringBuilder();
        while(k > 0) {
            if(k % factorial == 0) {
                result.append(sb.charAt((k / factorial) - 1));
                sb.deleteCharAt((k / factorial) - 1);
            } else {
                result.append(sb.charAt(k / factorial));
                sb.deleteCharAt(k / factorial);
            } 

            k %= factorial;
            factorial /= n;
            n--;
        }

        for(int i = sb.length() - 1; i >= 0; i--) result.append(sb.charAt(i));
        return result.toString();
    }
}
```
