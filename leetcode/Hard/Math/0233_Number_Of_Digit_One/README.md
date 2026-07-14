# Number of Digit One

## Metadata
![Difficulty: Hard](https://img.shields.io/badge/Difficulty-Hard-red?style=flat-square)
[![Topic: Math](https://img.shields.io/badge/Topic-Math-blue?style=flat-square)](https://leetcode.com/tag/math/) [![Topic: Dynamic Programming](https://img.shields.io/badge/Topic-Dynamic Programming-blue?style=flat-square)](https://leetcode.com/tag/dynamic-programming/) [![Topic: Recursion](https://img.shields.io/badge/Topic-Recursion-blue?style=flat-square)](https://leetcode.com/tag/recursion/)

- **LeetCode Link**: [https://leetcode.com/problems/number-of-digit-one/](https://leetcode.com/problems/number-of-digit-one/)
- **Problem ID**: 233
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
public int countDigitOne(int n) {

    if (n <= 0) return 0;
    int q = n, x = 1, ans = 0;
    do {
        int digit = q % 10;
        q /= 10;
        ans += q * x;
        if (digit == 1) ans += n % x + 1;
        if (digit >  1) ans += x;
        x *= 10;
    } while (q > 0);
    return ans;

}


}
```
