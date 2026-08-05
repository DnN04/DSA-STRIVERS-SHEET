# Predict the Winner

## Metadata
![Difficulty: Medium](https://img.shields.io/badge/Difficulty-Medium-orange?style=flat-square)
[![Topic: Array](https://img.shields.io/badge/Topic-Array-blue?style=flat-square)](https://leetcode.com/tag/array/) [![Topic: Math](https://img.shields.io/badge/Topic-Math-blue?style=flat-square)](https://leetcode.com/tag/math/) [![Topic: Dynamic Programming](https://img.shields.io/badge/Topic-Dynamic Programming-blue?style=flat-square)](https://leetcode.com/tag/dynamic-programming/) [![Topic: Recursion](https://img.shields.io/badge/Topic-Recursion-blue?style=flat-square)](https://leetcode.com/tag/recursion/) [![Topic: Minimax](https://img.shields.io/badge/Topic-Minimax-blue?style=flat-square)](https://leetcode.com/tag/minimax-algorithm/) [![Topic: Game Theory](https://img.shields.io/badge/Topic-Game Theory-blue?style=flat-square)](https://leetcode.com/tag/game-theory/) [![Topic: Zero-Sum Game](https://img.shields.io/badge/Topic-Zero-Sum Game-blue?style=flat-square)](https://leetcode.com/tag/zero-sum-game/)

- **LeetCode Link**: [https://leetcode.com/problems/predict-the-winner/](https://leetcode.com/problems/predict-the-winner/)
- **Problem ID**: 486
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
    public boolean predictTheWinner(int[] A) {
        int n = A.length;
        if ((n & 1) == 0) return true;

        int[][] dp = new int[n][n];
        for (int[] r : dp) 
            Arrays.fill(r, -1);
        
        return maxDiff(0, n - 1, A, dp) >= 0;
    }

    private int maxDiff(int i, int j, int[] A, int[][] dp) {
        if (dp[i][j] != -1) return dp[i][j];        
        if (i == j) return dp[i][j] = A[i];
        
        return dp[i][j] = Math.max(
            A[i] - maxDiff(i + 1, j, A, dp),
            A[j] - maxDiff(i, j - 1, A, dp)
        );
    }
}
```
