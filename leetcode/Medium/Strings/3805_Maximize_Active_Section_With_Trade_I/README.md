# Maximize Active Section with Trade I

## Metadata
![Difficulty: Medium](https://img.shields.io/badge/Difficulty-Medium-orange?style=flat-square)
[![Topic: String](https://img.shields.io/badge/Topic-String-blue?style=flat-square)](https://leetcode.com/tag/string/) [![Topic: Enumeration](https://img.shields.io/badge/Topic-Enumeration-blue?style=flat-square)](https://leetcode.com/tag/enumeration/)

- **LeetCode Link**: [https://leetcode.com/problems/maximize-active-section-with-trade-i/](https://leetcode.com/problems/maximize-active-section-with-trade-i/)
- **Problem ID**: 3805
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

    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();
        int cnt1 = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') cnt1++;
        }

        List<Integer> zeroBlocks = new ArrayList<>();
        int i = 0;
        while (i < n) {
            int start = i;
            while (i < n && s.charAt(i) == s.charAt(start)) {
                i++;
            }
            if (s.charAt(start) == '0') {
                zeroBlocks.add(i - start);
            }
        }

        int m = zeroBlocks.size();
        if (m < 2) {
            return cnt1;
        }
        int bestGain = 0; // Optimal Increment
        for (int j = 0; j < m - 1; j++) {
            bestGain = Math.max(
                bestGain,
                zeroBlocks.get(j) + zeroBlocks.get(j + 1)
            );
        }

        return cnt1 + bestGain;
    }
}
```
