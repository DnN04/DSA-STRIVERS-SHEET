# Maximum Product of Two Elements in an Array

## Metadata
![Difficulty: Easy](https://img.shields.io/badge/Difficulty-Easy-brightgreen?style=flat-square)
[![Topic: Array](https://img.shields.io/badge/Topic-Array-blue?style=flat-square)](https://leetcode.com/tag/array/) [![Topic: Sorting](https://img.shields.io/badge/Topic-Sorting-blue?style=flat-square)](https://leetcode.com/tag/sorting/) [![Topic: Heap (Priority Queue)](https://img.shields.io/badge/Topic-Heap (Priority Queue)-blue?style=flat-square)](https://leetcode.com/tag/heap-priority-queue/)

- **LeetCode Link**: [https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/](https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/)
- **Problem ID**: 1574
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
    public int maxProduct(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                ans = Math.max(ans, (nums[i] - 1) * (nums[j] - 1));
            }
        }
        
        return ans;
    }
}
```
