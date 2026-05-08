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
    int count = 0;
    public int goodNodes(TreeNode root) {
        dfs(root, root.val, -101);
        return count;
    }

    public void dfs(TreeNode root, int rootVal, int maxVal) {
        if(root == null)
            return;
        
        if(root.val >= rootVal && root.val >= maxVal) {
            maxVal = root.val;
            count++;
        }

        dfs(root.left, rootVal, maxVal);
        dfs(root.right, rootVal, maxVal);
    }
}
