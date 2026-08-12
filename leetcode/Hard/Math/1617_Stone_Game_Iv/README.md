# Stone Game IV

## Metadata
![Difficulty: Hard](https://img.shields.io/badge/Difficulty-Hard-red?style=flat-square)
[![Topic: Math](https://img.shields.io/badge/Topic-Math-blue?style=flat-square)](https://leetcode.com/tag/math/) [![Topic: Dynamic Programming](https://img.shields.io/badge/Topic-Dynamic Programming-blue?style=flat-square)](https://leetcode.com/tag/dynamic-programming/) [![Topic: Minimax](https://img.shields.io/badge/Topic-Minimax-blue?style=flat-square)](https://leetcode.com/tag/minimax-algorithm/) [![Topic: Game Theory](https://img.shields.io/badge/Topic-Game Theory-blue?style=flat-square)](https://leetcode.com/tag/game-theory/) [![Topic: Nim Game](https://img.shields.io/badge/Topic-Nim Game-blue?style=flat-square)](https://leetcode.com/tag/nim-game/) [![Topic: Sprague–Grundy Theorem](https://img.shields.io/badge/Topic-Sprague–Grundy Theorem-blue?style=flat-square)](https://leetcode.com/tag/sprague-grundy-theorem/) [![Topic: Zero-Sum Game](https://img.shields.io/badge/Topic-Zero-Sum Game-blue?style=flat-square)](https://leetcode.com/tag/zero-sum-game/)

- **LeetCode Link**: [https://leetcode.com/problems/stone-game-iv/](https://leetcode.com/problems/stone-game-iv/)
- **Problem ID**: 1617
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
    public boolean winnerSquareGame(int n) {

        boolean[] dp = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {

            // If i is a losing position,
            // every valid square move from i
            // creates a winning position.
            if (!dp[i]) {

                for (int j = 1; i + j * j <= n; j++) {
                    dp[i + j * j] = true;
                }

                // Once n becomes reachable from a losing position,
                // the first player can force a win.
                if (dp[n]) {
                    return true;
                }
            }
        }

        return false;
    }
}
```
