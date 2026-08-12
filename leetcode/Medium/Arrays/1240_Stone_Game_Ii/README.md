# Stone Game II

## Metadata
![Difficulty: Medium](https://img.shields.io/badge/Difficulty-Medium-orange?style=flat-square)
[![Topic: Array](https://img.shields.io/badge/Topic-Array-blue?style=flat-square)](https://leetcode.com/tag/array/) [![Topic: Math](https://img.shields.io/badge/Topic-Math-blue?style=flat-square)](https://leetcode.com/tag/math/) [![Topic: Dynamic Programming](https://img.shields.io/badge/Topic-Dynamic Programming-blue?style=flat-square)](https://leetcode.com/tag/dynamic-programming/) [![Topic: Minimax](https://img.shields.io/badge/Topic-Minimax-blue?style=flat-square)](https://leetcode.com/tag/minimax-algorithm/) [![Topic: Prefix Sum](https://img.shields.io/badge/Topic-Prefix Sum-blue?style=flat-square)](https://leetcode.com/tag/prefix-sum/) [![Topic: Game Theory](https://img.shields.io/badge/Topic-Game Theory-blue?style=flat-square)](https://leetcode.com/tag/game-theory/) [![Topic: Zero-Sum Game](https://img.shields.io/badge/Topic-Zero-Sum Game-blue?style=flat-square)](https://leetcode.com/tag/zero-sum-game/)

- **LeetCode Link**: [https://leetcode.com/problems/stone-game-ii/](https://leetcode.com/problems/stone-game-ii/)
- **Problem ID**: 1240
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

    public int stoneGameII(int[] piles) {
        int[] suffixSum = Arrays.copyOf(piles, piles.length);

        for (int i = suffixSum.length - 2; i >= 0; i--) {
            suffixSum[i] += suffixSum[i + 1];
        }
        return maxStones(suffixSum, 1, 0, new int[piles.length][piles.length]);
    }

    private int maxStones(
        int[] suffixSum,
        int maxTillNow,
        int currIndex,
        int[][] memo
    ) {
        if (currIndex + 2 * maxTillNow >= suffixSum.length) {
            return suffixSum[currIndex];
        }
        if (memo[currIndex][maxTillNow] > 0) return memo[currIndex][maxTillNow];
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= 2 * maxTillNow; i++) {
            res = Math.min(
                res,
                maxStones(
                    suffixSum,
                    Math.max(i, maxTillNow),
                    currIndex + i,
                    memo
                )
            );
        }
        memo[currIndex][maxTillNow] = suffixSum[currIndex] - res;
        return memo[currIndex][maxTillNow];
    }
}
```
