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
    int mx = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return mx;
    }

    public int dfs(TreeNode root) {
        if(root == null) return 0;

        int l = Math.max(dfs(root.left), 0);
        int r = Math.max(dfs(root.right), 0);

        mx = Math.max(mx, l + r + root.val);
        return Math.max(l, r) + root.val;
    }
}
