# Unique Paths II

## Metadata
![Difficulty: Medium](https://img.shields.io/badge/Difficulty-Medium-orange?style=flat-square)
[![Topic: Array](https://img.shields.io/badge/Topic-Array-blue?style=flat-square)](https://leetcode.com/tag/array/) [![Topic: Dynamic Programming](https://img.shields.io/badge/Topic-Dynamic Programming-blue?style=flat-square)](https://leetcode.com/tag/dynamic-programming/) [![Topic: Matrix](https://img.shields.io/badge/Topic-Matrix-blue?style=flat-square)](https://leetcode.com/tag/matrix/)

- **LeetCode Link**: [https://leetcode.com/problems/unique-paths-ii/](https://leetcode.com/problems/unique-paths-ii/)
- **Problem ID**: 63
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
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0 || obstacleGrid[0][0] == 1) {
            return 0;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[] previous = new int[n];
        int[] current = new int[n];
        previous[0] = 1;

        for (int i = 0; i < m; i++) {
            current[0] = obstacleGrid[i][0] == 1 ? 0 : previous[0];
            for (int j = 1; j < n; j++) {
                current[j] = obstacleGrid[i][j] == 1 ? 0 : current[j-1] + previous[j];
            }
            System.arraycopy(current, 0, previous, 0, n);
        }

        return previous[n-1];
    }
}
```
