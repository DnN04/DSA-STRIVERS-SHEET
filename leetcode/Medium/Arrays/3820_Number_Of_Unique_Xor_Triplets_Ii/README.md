# Number of Unique XOR Triplets II

## Metadata
![Difficulty: Medium](https://img.shields.io/badge/Difficulty-Medium-orange?style=flat-square)
[![Topic: Array](https://img.shields.io/badge/Topic-Array-blue?style=flat-square)](https://leetcode.com/tag/array/) [![Topic: Math](https://img.shields.io/badge/Topic-Math-blue?style=flat-square)](https://leetcode.com/tag/math/) [![Topic: Bit Manipulation](https://img.shields.io/badge/Topic-Bit Manipulation-blue?style=flat-square)](https://leetcode.com/tag/bit-manipulation/) [![Topic: Enumeration](https://img.shields.io/badge/Topic-Enumeration-blue?style=flat-square)](https://leetcode.com/tag/enumeration/)

- **LeetCode Link**: [https://leetcode.com/problems/number-of-unique-xor-triplets-ii/](https://leetcode.com/problems/number-of-unique-xor-triplets-ii/)
- **Problem ID**: 3820
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

    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        int m = 0;
        for (int v : nums) {
            m = Math.max(m, v);
        }
        int u = 1;
        while (u <= m) {
            u <<= 1;
        }
        boolean[] s = new boolean[u];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                s[nums[i] ^ nums[j]] = true;
            }
        }
        boolean[] t = new boolean[u];
        for (int x = 0; x < u; x++) {
            if (!s[x]) {
                continue;
            }
            for (int v : nums) {
                t[x ^ v] = true;
            }
        }
        int ans = 0;
        for (boolean b : t) {
            if (b) {
                ans++;
            }
        }
        return ans;
    }
}
```
