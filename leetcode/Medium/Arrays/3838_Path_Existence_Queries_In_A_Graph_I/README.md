# Path Existence Queries in a Graph I

## Metadata
![Difficulty: Medium](https://img.shields.io/badge/Difficulty-Medium-orange?style=flat-square)
[![Topic: Array](https://img.shields.io/badge/Topic-Array-blue?style=flat-square)](https://leetcode.com/tag/array/) [![Topic: Hash Table](https://img.shields.io/badge/Topic-Hash Table-blue?style=flat-square)](https://leetcode.com/tag/hash-table/) [![Topic: Binary Search](https://img.shields.io/badge/Topic-Binary Search-blue?style=flat-square)](https://leetcode.com/tag/binary-search/) [![Topic: Union-Find](https://img.shields.io/badge/Topic-Union-Find-blue?style=flat-square)](https://leetcode.com/tag/union-find/) [![Topic: Graph Theory](https://img.shields.io/badge/Topic-Graph Theory-blue?style=flat-square)](https://leetcode.com/tag/graph/)

- **LeetCode Link**: [https://leetcode.com/problems/path-existence-queries-in-a-graph-i/](https://leetcode.com/problems/path-existence-queries-in-a-graph-i/)
- **Problem ID**: 3838
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
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] comp = new int[n];
        comp[0] = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] <= maxDiff) {
                comp[i] = comp[i - 1];
            } else {
                comp[i] = comp[i - 1] + 1;
            }
        }

        boolean[] ans = new boolean[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            ans[i] = (comp[u] == comp[v]);
        }

        return ans;
    }
}
```
