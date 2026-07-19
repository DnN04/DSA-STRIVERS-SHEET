# Remove Duplicates from Sorted Array

## Metadata
![Difficulty: Easy](https://img.shields.io/badge/Difficulty-Easy-brightgreen?style=flat-square)
[![Topic: Array](https://img.shields.io/badge/Topic-Array-blue?style=flat-square)](https://leetcode.com/tag/array/) [![Topic: Two Pointers](https://img.shields.io/badge/Topic-Two Pointers-blue?style=flat-square)](https://leetcode.com/tag/two-pointers/)

- **LeetCode Link**: [https://leetcode.com/problems/remove-duplicates-from-sorted-array/](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)
- **Problem ID**: 26
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
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int i = 1;

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i - 1]) {
                nums[i] = nums[j];
                i++;
            }
        }

        return i;        
    }
}
```
