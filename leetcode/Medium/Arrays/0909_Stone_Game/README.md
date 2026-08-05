# Stone Game

## Metadata
![Difficulty: Medium](https://img.shields.io/badge/Difficulty-Medium-orange?style=flat-square)
[![Topic: Array](https://img.shields.io/badge/Topic-Array-blue?style=flat-square)](https://leetcode.com/tag/array/) [![Topic: Math](https://img.shields.io/badge/Topic-Math-blue?style=flat-square)](https://leetcode.com/tag/math/) [![Topic: Dynamic Programming](https://img.shields.io/badge/Topic-Dynamic Programming-blue?style=flat-square)](https://leetcode.com/tag/dynamic-programming/) [![Topic: Minimax](https://img.shields.io/badge/Topic-Minimax-blue?style=flat-square)](https://leetcode.com/tag/minimax-algorithm/) [![Topic: Game Theory](https://img.shields.io/badge/Topic-Game Theory-blue?style=flat-square)](https://leetcode.com/tag/game-theory/) [![Topic: Zero-Sum Game](https://img.shields.io/badge/Topic-Zero-Sum Game-blue?style=flat-square)](https://leetcode.com/tag/zero-sum-game/)

- **LeetCode Link**: [https://leetcode.com/problems/stone-game/](https://leetcode.com/problems/stone-game/)
- **Problem ID**: 909
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
    public boolean stoneGame(int[] piles) {
        int N = piles.length;
        int[][] dp = new int[N+2][N+2];
        for (int size = 1; size <= N; ++size)
            for (int i = 0; i + size <= N; ++i) {
                int j = i + size - 1;
                int parity = (j + i + N) % 2;  
                if (parity == 1)
                    dp[i+1][j+1] = Math.max(piles[i] + dp[i+2][j+1], piles[j] + dp[i+1][j]);
                else
                    dp[i+1][j+1] = Math.min(-piles[i] + dp[i+2][j+1], -piles[j] + dp[i+1][j]);
            }

        return dp[1][N] > 0;
    }
}
```
