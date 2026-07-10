# Path Existence Queries in a Graph II

## Metadata
![Difficulty: Hard](https://img.shields.io/badge/Difficulty-Hard-red?style=flat-square)
[![Topic: Array](https://img.shields.io/badge/Topic-Array-blue?style=flat-square)](https://leetcode.com/tag/array/) [![Topic: Two Pointers](https://img.shields.io/badge/Topic-Two Pointers-blue?style=flat-square)](https://leetcode.com/tag/two-pointers/) [![Topic: Binary Search](https://img.shields.io/badge/Topic-Binary Search-blue?style=flat-square)](https://leetcode.com/tag/binary-search/) [![Topic: Dynamic Programming](https://img.shields.io/badge/Topic-Dynamic Programming-blue?style=flat-square)](https://leetcode.com/tag/dynamic-programming/) [![Topic: Greedy](https://img.shields.io/badge/Topic-Greedy-blue?style=flat-square)](https://leetcode.com/tag/greedy/) [![Topic: Bit Manipulation](https://img.shields.io/badge/Topic-Bit Manipulation-blue?style=flat-square)](https://leetcode.com/tag/bit-manipulation/) [![Topic: Graph Theory](https://img.shields.io/badge/Topic-Graph Theory-blue?style=flat-square)](https://leetcode.com/tag/graph/) [![Topic: Sorting](https://img.shields.io/badge/Topic-Sorting-blue?style=flat-square)](https://leetcode.com/tag/sorting/)

- **LeetCode Link**: [https://leetcode.com/problems/path-existence-queries-in-a-graph-ii/](https://leetcode.com/problems/path-existence-queries-in-a-graph-ii/)
- **Problem ID**: 3852
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
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[][] newNums = new int[n][2];
        for (int i = 0; i < n; i++) newNums[i] = new int[]{nums[i], i};
        Arrays.sort(newNums, (a, b) -> a[0] - b[0]);

        int[] getI = new int[n];
        for (int i = 0; i < n; i++) getI[newNums[i][1]] = i;

        int[][] st = new int[n][18];
        int r = 0;
        for (int i = 0; i < n; i++) {
            if (r < i) r = i;
            while (r + 1 < n &&
                   newNums[r + 1][0] - newNums[r][0] <= maxDiff &&
                   newNums[r + 1][0] - newNums[i][0] <= maxDiff)
                r++;
            st[i][0] = r;
        }

        for (int j = 1; j < 18; j++)
            for (int i = 0; i < n; i++)
                st[i][j] = st[st[i][j - 1]][j - 1];

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int a = getI[queries[i][0]], b = getI[queries[i][1]];
            if (a > b) { int t = a; a = b; b = t; }
            if (a == b) { ans[i] = 0; continue; }

            int curr = a, steps = 0;
            for (int j = 17; j >= 0; j--)
                if (st[curr][j] < b) { curr = st[curr][j]; steps += (1 << j); }

            ans[i] = (st[curr][0] >= b) ? steps + 1 : -1;
        }
        return ans;
    }
}
```
