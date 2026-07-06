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
    public int pubk = 0;
    public int output = 0;
    public int kthSmallest(TreeNode root, int k) {
        pubk = k;
        recursive(root);
        return output;
    }

    private void recursive(TreeNode root) {
        if (root == null || output != 0) {
            return;
        } else {
            recursive(root.left);
            if (pubk == 1) {
                output = root.val;
            }
            pubk--;
            recursive(root.right);
        }
    }
}
