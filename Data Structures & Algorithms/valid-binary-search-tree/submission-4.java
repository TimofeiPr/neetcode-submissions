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
    public boolean isValidBST(TreeNode root) {
        return recursive(root.left, Integer.MIN_VALUE, root.val) && recursive(root.right, root.val, Integer.MAX_VALUE);
    }
    private boolean recursive(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        } else if (root.val <= min || root.val >= max) {
            return false;
        } else {
            return recursive(root.left, min, root.val) && recursive(root.right, root.val, max);
        }
    }
}
