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
    int output = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        recursive(root);
        return output;
    }

    private int recursive(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left = Math.max(0, recursive(root.left));
            int right = Math.max(0, recursive(root.right));

            output = Math.max(output, (root.val + left + right));
            return (root.val + Math.max(left, right));
        }
    }
}
