# Binary Tree Maximum Path Sum

## Metadata
![Difficulty: Hard](https://img.shields.io/badge/Difficulty-Hard-red?style=flat-square)
[![Topic: Dynamic Programming](https://img.shields.io/badge/Topic-Dynamic Programming-blue?style=flat-square)](https://leetcode.com/tag/dynamic-programming/) [![Topic: Tree](https://img.shields.io/badge/Topic-Tree-blue?style=flat-square)](https://leetcode.com/tag/tree/) [![Topic: Depth-First Search](https://img.shields.io/badge/Topic-Depth-First Search-blue?style=flat-square)](https://leetcode.com/tag/depth-first-search/) [![Topic: Binary Tree](https://img.shields.io/badge/Topic-Binary Tree-blue?style=flat-square)](https://leetcode.com/tag/binary-tree/)

- **LeetCode Link**: [https://leetcode.com/problems/binary-tree-maximum-path-sum/](https://leetcode.com/problems/binary-tree-maximum-path-sum/)
- **Problem ID**: 124
- **Language**: C

## Solution Design

### Method Explanation
- *We solve this problem by leveraging standard data structures or algorithms suitable for the problem constraints.*
- *Make sure to update this section with notes on your implementation approaches.*

### Complexity Analysis
- **Time Complexity**: \(O(N)\) (where \(N\) is the number of elements)
- **Space Complexity**: \(O(1)\) auxiliary space

## Solution Code

```c
int solve(struct TreeNode* root, int* best) {
    if (root == NULL)
        return 0;
    int a = solve(root->left, best);
    int b = solve(root->right, best);
    a = a > 0 ? a : 0;
    b = b > 0 ? b : 0;
    *best = *best > a + b + root->val ? *best : a + b + root->val;
    return root->val + (a > b ? a : b);
}

int maxPathSum(struct TreeNode* root) {
    int best = INT_MIN;
    solve(root, &best);
    return best;
}
```
