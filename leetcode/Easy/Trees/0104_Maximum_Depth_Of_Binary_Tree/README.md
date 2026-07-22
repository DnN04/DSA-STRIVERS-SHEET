# Maximum Depth of Binary Tree

## Metadata
![Difficulty: Easy](https://img.shields.io/badge/Difficulty-Easy-brightgreen?style=flat-square)
[![Topic: Tree](https://img.shields.io/badge/Topic-Tree-blue?style=flat-square)](https://leetcode.com/tag/tree/) [![Topic: Depth-First Search](https://img.shields.io/badge/Topic-Depth-First Search-blue?style=flat-square)](https://leetcode.com/tag/depth-first-search/) [![Topic: Breadth-First Search](https://img.shields.io/badge/Topic-Breadth-First Search-blue?style=flat-square)](https://leetcode.com/tag/breadth-first-search/) [![Topic: Binary Tree](https://img.shields.io/badge/Topic-Binary Tree-blue?style=flat-square)](https://leetcode.com/tag/binary-tree/)

- **LeetCode Link**: [https://leetcode.com/problems/maximum-depth-of-binary-tree/](https://leetcode.com/problems/maximum-depth-of-binary-tree/)
- **Problem ID**: 104
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
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        
        return 1 + Math.max(leftDepth, rightDepth);
    }
}
```
