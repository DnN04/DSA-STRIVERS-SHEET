# Valid Number

## Metadata
![Difficulty: Hard](https://img.shields.io/badge/Difficulty-Hard-red?style=flat-square)
[![Topic: String](https://img.shields.io/badge/Topic-String-blue?style=flat-square)](https://leetcode.com/tag/string/)

- **LeetCode Link**: [https://leetcode.com/problems/valid-number/](https://leetcode.com/problems/valid-number/)
- **Problem ID**: 65
- **Language**: Python3

## Solution Design

### Method Explanation
- *We solve this problem by leveraging standard data structures or algorithms suitable for the problem constraints.*
- *Make sure to update this section with notes on your implementation approaches.*

### Complexity Analysis
- **Time Complexity**: \(O(N)\) (where \(N\) is the number of elements)
- **Space Complexity**: \(O(1)\) auxiliary space

## Solution Code

```python
class Solution:
    def isNumber(self, s: str) -> bool:
        try:
            return (float(s) or int(float(s)) == 0) and not ('n'in s)
        except:
            return(False)
```
