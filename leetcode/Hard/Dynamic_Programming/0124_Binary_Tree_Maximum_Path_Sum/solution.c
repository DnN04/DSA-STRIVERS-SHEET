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