# Count the Number of Complete Components

## Metadata
![Difficulty: Medium](https://img.shields.io/badge/Difficulty-Medium-orange?style=flat-square)
[![Topic: Depth-First Search](https://img.shields.io/badge/Topic-Depth-First Search-blue?style=flat-square)](https://leetcode.com/tag/depth-first-search/) [![Topic: Breadth-First Search](https://img.shields.io/badge/Topic-Breadth-First Search-blue?style=flat-square)](https://leetcode.com/tag/breadth-first-search/) [![Topic: Union-Find](https://img.shields.io/badge/Topic-Union-Find-blue?style=flat-square)](https://leetcode.com/tag/union-find/) [![Topic: Graph Theory](https://img.shields.io/badge/Topic-Graph Theory-blue?style=flat-square)](https://leetcode.com/tag/graph/)

- **LeetCode Link**: [https://leetcode.com/problems/count-the-number-of-complete-components/](https://leetcode.com/problems/count-the-number-of-complete-components/)
- **Problem ID**: 2793
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

    public int countCompleteComponents(int n, int[][] edges) {
        // Adjacency lists for each vertex
        List<Integer>[] graph = new ArrayList[n];
        // Map to store frequency of each unique adjacency list
        Map<List<Integer>, Integer> componentFreq = new HashMap<>();

        // Initialize adjacency lists with self-loops
        for (int vertex = 0; vertex < n; vertex++) {
            graph[vertex] = new ArrayList<>();
            graph[vertex].add(vertex);
        }

        // Build adjacency lists from edges
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        // Count frequency of each unique adjacency pattern
        for (int vertex = 0; vertex < n; vertex++) {
            List<Integer> neighbors = graph[vertex];
            Collections.sort(neighbors);
            componentFreq.put(
                neighbors,
                componentFreq.getOrDefault(neighbors, 0) + 1
            );
        }

        // Count complete components where size equals frequency
        int completeCount = 0;
        for (Map.Entry<
            List<Integer>,
            Integer
        > entry : componentFreq.entrySet()) {
            if (entry.getKey().size() == entry.getValue()) {
                completeCount++;
            }
        }

        return completeCount;
    }
}
```
