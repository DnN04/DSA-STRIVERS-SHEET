# Permutations II

## Metadata
![Difficulty: Medium](https://img.shields.io/badge/Difficulty-Medium-orange?style=flat-square)
[![Topic: Array](https://img.shields.io/badge/Topic-Array-blue?style=flat-square)](https://leetcode.com/tag/array/) [![Topic: Backtracking](https://img.shields.io/badge/Topic-Backtracking-blue?style=flat-square)](https://leetcode.com/tag/backtracking/) [![Topic: Sorting](https://img.shields.io/badge/Topic-Sorting-blue?style=flat-square)](https://leetcode.com/tag/sorting/)

- **LeetCode Link**: [https://leetcode.com/problems/permutations-ii/](https://leetcode.com/problems/permutations-ii/)
- **Problem ID**: 47
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
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();

        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            if (!counter.containsKey(num)) counter.put(num, 0);
            counter.put(num, counter.get(num) + 1);
        }

        LinkedList<Integer> comb = new LinkedList<>();
        this.backtrack(comb, nums.length, counter, results);
        return results;
    }

    protected void backtrack(
        LinkedList<Integer> comb,
        Integer N,
        HashMap<Integer, Integer> counter,
        List<List<Integer>> results
    ) {
        if (comb.size() == N) {
            results.add(new ArrayList<Integer>(comb));
            return;
        }

        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            Integer num = entry.getKey();
            Integer count = entry.getValue();
            if (count == 0) continue;
            comb.addLast(num);
            counter.put(num, count - 1);
            backtrack(comb, N, counter, results);

            comb.removeLast();
            counter.put(num, count);
        }
    }
}
```
