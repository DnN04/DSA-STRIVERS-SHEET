# Minimum Number of Pushes to Type Word II

## Metadata
![Difficulty: Medium](https://img.shields.io/badge/Difficulty-Medium-orange?style=flat-square)
[![Topic: Hash Table](https://img.shields.io/badge/Topic-Hash Table-blue?style=flat-square)](https://leetcode.com/tag/hash-table/) [![Topic: String](https://img.shields.io/badge/Topic-String-blue?style=flat-square)](https://leetcode.com/tag/string/) [![Topic: Greedy](https://img.shields.io/badge/Topic-Greedy-blue?style=flat-square)](https://leetcode.com/tag/greedy/) [![Topic: Sorting](https://img.shields.io/badge/Topic-Sorting-blue?style=flat-square)](https://leetcode.com/tag/sorting/) [![Topic: Counting](https://img.shields.io/badge/Topic-Counting-blue?style=flat-square)](https://leetcode.com/tag/counting/)

- **LeetCode Link**: [https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-ii/](https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-ii/)
- **Problem ID**: 3276
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

    public int minimumPushes(String word) {
        int[] frequency = new int[26];

        for (char c : word.toCharArray()) {
            frequency[c - 'a']++;
        }

        Arrays.sort(frequency);
        int[] sortedFrequency = new int[26];
        for (int i = 0; i < 26; i++) {
            sortedFrequency[i] = frequency[25 - i];
        }


        int totalPushes = 0;

        for (int i = 0; i < 26; i++) {
            if (sortedFrequency[i] == 0) break;
            totalPushes += (i / 8 + 1) * sortedFrequency[i];
        }

        return totalPushes;
    }
}
```
