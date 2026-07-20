# Shift 2D Grid

## Metadata
![Difficulty: Easy](https://img.shields.io/badge/Difficulty-Easy-brightgreen?style=flat-square)
[![Topic: Array](https://img.shields.io/badge/Topic-Array-blue?style=flat-square)](https://leetcode.com/tag/array/) [![Topic: Matrix](https://img.shields.io/badge/Topic-Matrix-blue?style=flat-square)](https://leetcode.com/tag/matrix/) [![Topic: Simulation](https://img.shields.io/badge/Topic-Simulation-blue?style=flat-square)](https://leetcode.com/tag/simulation/)

- **LeetCode Link**: [https://leetcode.com/problems/shift-2d-grid/](https://leetcode.com/problems/shift-2d-grid/)
- **Problem ID**: 1386
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
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int total = m * n;
        k %= total;

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++)
                row.add(0);
            ans.add(row);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // index in 1D array (before rotation)
                int oldIndex = i * n + j;

                // index in 1D array (after rotation)
                int newIndex = (oldIndex + k) % total;

                // changing from 1D back to 2D
                int newRow = newIndex / n;
                int newCol = newIndex % n;

                ans.get(newRow).set(newCol, grid[i][j]);
            }
        }

        return ans;
    }
}
```
