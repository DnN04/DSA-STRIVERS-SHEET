# Sorted GCD Pair Queries

## Metadata
![Difficulty: Hard](https://img.shields.io/badge/Difficulty-Hard-red?style=flat-square)
[![Topic: Array](https://img.shields.io/badge/Topic-Array-blue?style=flat-square)](https://leetcode.com/tag/array/) [![Topic: Hash Table](https://img.shields.io/badge/Topic-Hash Table-blue?style=flat-square)](https://leetcode.com/tag/hash-table/) [![Topic: Math](https://img.shields.io/badge/Topic-Math-blue?style=flat-square)](https://leetcode.com/tag/math/) [![Topic: Binary Search](https://img.shields.io/badge/Topic-Binary Search-blue?style=flat-square)](https://leetcode.com/tag/binary-search/) [![Topic: Combinatorics](https://img.shields.io/badge/Topic-Combinatorics-blue?style=flat-square)](https://leetcode.com/tag/combinatorics/) [![Topic: Counting](https://img.shields.io/badge/Topic-Counting-blue?style=flat-square)](https://leetcode.com/tag/counting/) [![Topic: Number Theory](https://img.shields.io/badge/Topic-Number Theory-blue?style=flat-square)](https://leetcode.com/tag/number-theory/) [![Topic: Prefix Sum](https://img.shields.io/badge/Topic-Prefix Sum-blue?style=flat-square)](https://leetcode.com/tag/prefix-sum/)

- **LeetCode Link**: [https://leetcode.com/problems/sorted-gcd-pair-queries/](https://leetcode.com/problems/sorted-gcd-pair-queries/)
- **Problem ID**: 3583
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

    public int[] gcdValues(int[] nums, long[] queries) {
        int m = 0;
        for (int num : nums) {
            m = Math.max(m, num);
        }
        long[] cnt = new long[m + 1];
        for (int num : nums) {
            cnt[num]++;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = i * 2; j <= m; j += i) {
                cnt[i] += cnt[j];
            }
        }
        for (int i = 1; i <= m; i++) {
            cnt[i] = (cnt[i] * (cnt[i] - 1)) / 2;
        }
        for (int i = m; i >= 1; i--) {
            for (int j = i * 2; j <= m; j += i) {
                cnt[i] -= cnt[j];
            }
        }
        for (int i = 1; i <= m; i++) {
            cnt[i] += cnt[i - 1];
        }
        int[] ans = new int[queries.length];
        for (int k = 0; k < queries.length; k++) {
            long q = queries[k] + 1;
            int left = 1,
                right = m;
            while (left < right) {
                int mid = (left + right) / 2;
                if (cnt[mid] >= q) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            ans[k] = left;
        }
        return ans;
    }
}
```
