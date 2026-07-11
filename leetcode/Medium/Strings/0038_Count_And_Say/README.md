# Count and Say

## Metadata
![Difficulty: Medium](https://img.shields.io/badge/Difficulty-Medium-orange?style=flat-square)
[![Topic: String](https://img.shields.io/badge/Topic-String-blue?style=flat-square)](https://leetcode.com/tag/string/)

- **LeetCode Link**: [https://leetcode.com/problems/count-and-say/](https://leetcode.com/problems/count-and-say/)
- **Problem ID**: 38
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
    public String RLE(String sequence) {
        StringBuilder sb = new StringBuilder();
        char[] nums = sequence.toCharArray();
        char curr = nums[0];
        int count = 0;
        
        
        for (char num : nums) {
            if (num == curr)
                count++;
            else {
                sb.append(count);
                sb.append(curr);
                curr = num;
                count = 1;
            }
        }
        
        
        sb.append(count);
        sb.append(curr);
        return sb.toString();
    }
    
    
    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        
        
        return RLE(countAndSay(n - 1));
    }
}
```
