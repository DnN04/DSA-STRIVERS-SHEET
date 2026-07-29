# Smallest Palindromic Rearrangement II

## Metadata
![Difficulty: Hard](https://img.shields.io/badge/Difficulty-Hard-red?style=flat-square)
[![Topic: Hash Table](https://img.shields.io/badge/Topic-Hash Table-blue?style=flat-square)](https://leetcode.com/tag/hash-table/) [![Topic: Math](https://img.shields.io/badge/Topic-Math-blue?style=flat-square)](https://leetcode.com/tag/math/) [![Topic: String](https://img.shields.io/badge/Topic-String-blue?style=flat-square)](https://leetcode.com/tag/string/) [![Topic: Combinatorics](https://img.shields.io/badge/Topic-Combinatorics-blue?style=flat-square)](https://leetcode.com/tag/combinatorics/) [![Topic: Counting](https://img.shields.io/badge/Topic-Counting-blue?style=flat-square)](https://leetcode.com/tag/counting/)

- **LeetCode Link**: [https://leetcode.com/problems/smallest-palindromic-rearrangement-ii/](https://leetcode.com/problems/smallest-palindromic-rearrangement-ii/)
- **Problem ID**: 3813
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

    private long comb(long n, long m, long k) {
        long res = 1;
        m = Math.min(m, n - m);

        for (long i = 1; i <= m; i++) {
            res = (res * (n - i + 1)) / i;
            if (res > k) {
                return k + 1;
            }
        }
        return res;
    }

    private long permutations(int rem, int[] bucket, long k) {
        long ways = 1;
        for (int i = 0; i < 26; i++) {
            if (bucket[i] == 0) {
                continue;
            }

            ways *= comb(rem, bucket[i], k);
            if (ways > k) {
                break;
            }
            rem -= bucket[i];
        }
        return ways;
    }

    public String smallestPalindrome(String s, long k) {
        int partition = s.length() / 2;
        int[] bucket = new int[26];

        for (int i = 0; i < partition; i++) {
            bucket[s.charAt(i) - 97] += 1;
        }

        StringBuilder left = new StringBuilder();
        long startIndex = 1;

        for (int pos = 0; pos < partition; pos++) {
            for (int i = 0; i < 26; i++) {
                if (bucket[i] == 0) {
                    continue;
                }

                bucket[i] -= 1;

                long ways = permutations(partition - pos - 1, bucket, k);
                if (startIndex + ways > k) {
                    left.append((char) (i + 97));
                    break;
                }

                bucket[i] += 1;
                startIndex += ways;
            }
        }

        if (left.length() < partition) {
            return "";
        }

        if (s.length() % 2 != 0) {
            left.append(s.charAt(partition));
        }

        for (int i = partition - 1; i >= 0; i--) {
            left.append(left.charAt(i));
        }

        return left.toString();
    }
}
```
