# Find Missing Elements

## Metadata
![Difficulty: Easy](https://img.shields.io/badge/Difficulty-Easy-brightgreen?style=flat-square)
[![Topic: Array](https://img.shields.io/badge/Topic-Array-blue?style=flat-square)](https://leetcode.com/tag/array/) [![Topic: Hash Table](https://img.shields.io/badge/Topic-Hash Table-blue?style=flat-square)](https://leetcode.com/tag/hash-table/) [![Topic: Sorting](https://img.shields.io/badge/Topic-Sorting-blue?style=flat-square)](https://leetcode.com/tag/sorting/)

- **LeetCode Link**: [https://leetcode.com/problems/find-missing-elements/](https://leetcode.com/problems/find-missing-elements/)
- **Problem ID**: 4107
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

    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = nums[i] + 1; j < nums[i + 1]; j++) {
                ans.add(j);
            }
        }

        return ans;
    }
}
```
