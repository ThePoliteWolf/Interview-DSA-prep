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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            List<TreeNode> list = new ArrayList<>();
            while (!q.isEmpty()) {
                list.add(q.poll());
            }
        
            TreeNode rightSide = null;
            for (TreeNode node : list) {
                rightSide = node;
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
                
            }

            if(rightSide != null) 
                ans.add(rightSide.val);
        }
        return ans;
    }
}
