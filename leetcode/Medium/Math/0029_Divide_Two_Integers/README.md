# Divide Two Integers

## Metadata
![Difficulty: Medium](https://img.shields.io/badge/Difficulty-Medium-orange?style=flat-square)
[![Topic: Math](https://img.shields.io/badge/Topic-Math-blue?style=flat-square)](https://leetcode.com/tag/math/) [![Topic: Bit Manipulation](https://img.shields.io/badge/Topic-Bit Manipulation-blue?style=flat-square)](https://leetcode.com/tag/bit-manipulation/)

- **LeetCode Link**: [https://leetcode.com/problems/divide-two-integers/](https://leetcode.com/problems/divide-two-integers/)
- **Problem ID**: 29
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
import java.math.*;
class Solution {
    public int divide(int dividend, int divisor) {
        
        int quo = dividend / divisor;
        if(dividend==Integer.MIN_VALUE && divisor==-1){
            return Integer.MAX_VALUE;
        }
        return quo;
    }
}
```
