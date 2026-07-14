# Basic Calculator

## Metadata
![Difficulty: Hard](https://img.shields.io/badge/Difficulty-Hard-red?style=flat-square)
[![Topic: Math](https://img.shields.io/badge/Topic-Math-blue?style=flat-square)](https://leetcode.com/tag/math/) [![Topic: String](https://img.shields.io/badge/Topic-String-blue?style=flat-square)](https://leetcode.com/tag/string/) [![Topic: Stack](https://img.shields.io/badge/Topic-Stack-blue?style=flat-square)](https://leetcode.com/tag/stack/) [![Topic: Recursion](https://img.shields.io/badge/Topic-Recursion-blue?style=flat-square)](https://leetcode.com/tag/recursion/)

- **LeetCode Link**: [https://leetcode.com/problems/basic-calculator/](https://leetcode.com/problems/basic-calculator/)
- **Problem ID**: 224
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
    public int calculate(String s) {

        Stack<Integer> stack = new Stack<>();

        int res = 0;
        int curr = 0;
        int sign = 1;

        for (char c : s.toCharArray()) {

            if (Character.isDigit(c)) {
                curr = curr * 10 + (c - '0');
            } 
            else if (c == '+') {
                res += curr * sign;
                sign = 1;
                curr = 0;
            } 
            else if (c == '-') {
                res += curr * sign;
                sign = -1;
                curr = 0;
            } 
            else if (c == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
                curr = 0;
            } 
            else if (c == ')') {
                res += curr * sign;
                curr = 0;
                res *= stack.pop();
                res += stack.pop();
            }
        }

        res += sign * curr;
        return res;
    }
}
```
