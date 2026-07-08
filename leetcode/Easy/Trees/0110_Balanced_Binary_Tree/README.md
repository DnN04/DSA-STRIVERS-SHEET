# Balanced Binary Tree

## Metadata
![Difficulty: Easy](https://img.shields.io/badge/Difficulty-Easy-brightgreen?style=flat-square)
[![Topic: Tree](https://img.shields.io/badge/Topic-Tree-blue?style=flat-square)](https://leetcode.com/tag/tree/) [![Topic: Depth-First Search](https://img.shields.io/badge/Topic-Depth-First Search-blue?style=flat-square)](https://leetcode.com/tag/depth-first-search/) [![Topic: Binary Tree](https://img.shields.io/badge/Topic-Binary Tree-blue?style=flat-square)](https://leetcode.com/tag/binary-tree/)

- **LeetCode Link**: [https://leetcode.com/problems/balanced-binary-tree/](https://leetcode.com/problems/balanced-binary-tree/)
- **Problem ID**: 110
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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        return isHeight(root) != -1;
    }

    public int isHeight(TreeNode root) {
        if (root == null) return 0;

        int lh = isHeight(root.left);
        if (lh == -1) return -1;

        int rh = isHeight(root.right);
        if (rh == -1) return -1;

        if (Math.abs(lh - rh) > 1) return -1;

        return Math.max(lh, rh) + 1;
    }
}
```
