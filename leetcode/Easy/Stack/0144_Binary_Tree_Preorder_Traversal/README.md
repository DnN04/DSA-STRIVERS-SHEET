# Binary Tree Preorder Traversal

## Metadata
![Difficulty: Easy](https://img.shields.io/badge/Difficulty-Easy-brightgreen?style=flat-square)
[![Topic: Stack](https://img.shields.io/badge/Topic-Stack-blue?style=flat-square)](https://leetcode.com/tag/stack/) [![Topic: Tree](https://img.shields.io/badge/Topic-Tree-blue?style=flat-square)](https://leetcode.com/tag/tree/) [![Topic: Depth-First Search](https://img.shields.io/badge/Topic-Depth-First Search-blue?style=flat-square)](https://leetcode.com/tag/depth-first-search/) [![Topic: Binary Tree](https://img.shields.io/badge/Topic-Binary Tree-blue?style=flat-square)](https://leetcode.com/tag/binary-tree/)

- **LeetCode Link**: [https://leetcode.com/problems/binary-tree-preorder-traversal/](https://leetcode.com/problems/binary-tree-preorder-traversal/)
- **Problem ID**: 144
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer>list=new ArrayList<>();
        helper(root,list);
        return list;
    }
    public void helper(TreeNode node,List<Integer>list){
        if(node==null)return;
        list.add(node.val);
        helper(node.left,list);
        helper(node.right,list);
    }
}
```
