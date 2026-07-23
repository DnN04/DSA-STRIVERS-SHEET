# Binary Tree Postorder Traversal

## Metadata
![Difficulty: Easy](https://img.shields.io/badge/Difficulty-Easy-brightgreen?style=flat-square)
[![Topic: Stack](https://img.shields.io/badge/Topic-Stack-blue?style=flat-square)](https://leetcode.com/tag/stack/) [![Topic: Tree](https://img.shields.io/badge/Topic-Tree-blue?style=flat-square)](https://leetcode.com/tag/tree/) [![Topic: Depth-First Search](https://img.shields.io/badge/Topic-Depth-First Search-blue?style=flat-square)](https://leetcode.com/tag/depth-first-search/) [![Topic: Binary Tree](https://img.shields.io/badge/Topic-Binary Tree-blue?style=flat-square)](https://leetcode.com/tag/binary-tree/)

- **LeetCode Link**: [https://leetcode.com/problems/binary-tree-postorder-traversal/](https://leetcode.com/problems/binary-tree-postorder-traversal/)
- **Problem ID**: 145
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

    private void postorderTraversalHelper(
        TreeNode currentNode,
        List<Integer> result
    ) {
        // Base case: if the node is null, return
        if (currentNode == null) {
            return;
        }
        // Traverse left subtree
        postorderTraversalHelper(currentNode.left, result);
        // Traverse right subtree
        postorderTraversalHelper(currentNode.right, result);
        // Add the current node's value to the result list
        result.add(currentNode.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        // Start traversal from root
        postorderTraversalHelper(root, result);
        return result;
    }
}
```
