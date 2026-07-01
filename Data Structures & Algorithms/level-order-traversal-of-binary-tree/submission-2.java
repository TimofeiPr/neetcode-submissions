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
    List<List<Integer>> output = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        recursive(root, 0);
        return output;
    }
    private void recursive(TreeNode root, int level) {
        if (root == null) {
        } else {
            if (output.isEmpty() || output.size() <= level) {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.add(root.val);
                output.add(temp);
            } else {
                output.get(level).add(root.val);
            }
            level += 1;
            recursive(root.left, level);
            recursive(root.right, level);
        }
    }
}
