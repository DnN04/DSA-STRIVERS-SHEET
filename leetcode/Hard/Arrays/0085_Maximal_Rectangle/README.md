# Maximal Rectangle

## Metadata
![Difficulty: Hard](https://img.shields.io/badge/Difficulty-Hard-red?style=flat-square)
[![Topic: Array](https://img.shields.io/badge/Topic-Array-blue?style=flat-square)](https://leetcode.com/tag/array/) [![Topic: Dynamic Programming](https://img.shields.io/badge/Topic-Dynamic Programming-blue?style=flat-square)](https://leetcode.com/tag/dynamic-programming/) [![Topic: Stack](https://img.shields.io/badge/Topic-Stack-blue?style=flat-square)](https://leetcode.com/tag/stack/) [![Topic: Matrix](https://img.shields.io/badge/Topic-Matrix-blue?style=flat-square)](https://leetcode.com/tag/matrix/) [![Topic: Monotonic Stack](https://img.shields.io/badge/Topic-Monotonic Stack-blue?style=flat-square)](https://leetcode.com/tag/monotonic-stack/)

- **LeetCode Link**: [https://leetcode.com/problems/maximal-rectangle/](https://leetcode.com/problems/maximal-rectangle/)
- **Problem ID**: 85
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
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int M = matrix.length;
        int N = matrix[0].length;

        int[][] mat = new int[M][N];

        // convert char to int
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                mat[i][j] = matrix[i][j] - '0';
            }
        }

        // row-wise prefix widths
        for (int i = 0; i < M; i++) {
            for (int j = 1; j < N; j++) {
                if (mat[i][j] == 1) {
                    mat[i][j] += mat[i][j - 1];
                }
            }
        }

        int Ans = 0;

        // fix each column
        for (int j = 0; j < N; j++) {
            for (int i = 0; i < M; i++) {
                int width = mat[i][j];
                if (width == 0) continue;

                // expand downward
                int currWidth = width;
                for (int k = i; k < M && mat[k][j] > 0; k++) {
                    currWidth = Math.min(currWidth, mat[k][j]);
                    int height = k - i + 1;
                    Ans = Math.max(Ans, currWidth * height);
                }

                // expand upward
                currWidth = width;
                for (int k = i; k >= 0 && mat[k][j] > 0; k--) {
                    currWidth = Math.min(currWidth, mat[k][j]);
                    int height = i - k + 1;
                    Ans = Math.max(Ans, currWidth * height);
                }
            }
        }

        return Ans;
    }
}
```
