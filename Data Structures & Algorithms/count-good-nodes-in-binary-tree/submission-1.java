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
    int output = 0;
    public int goodNodes(TreeNode root) {
        recursive(root, root.val);
        return output;
    }

    private void recursive(TreeNode root, int max) {
        if (root == null) {
            return;
        } else if (root.val >= max) {
            output++; 
            max = root.val;
        }
        recursive(root.left, max);
        recursive(root.right, max);

    }
}
