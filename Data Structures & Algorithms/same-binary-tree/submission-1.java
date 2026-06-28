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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return (recursive(p, q) != -1);
    }

    private int recursive(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return 1;
        } else if (p == null || q == null) {
            return -1;
        } else if (p.val != q.val) {
            return -1;
        } else {
            return Math.min(recursive(p.left, q.left), recursive(p.right, q.right));

        }
    }
}
