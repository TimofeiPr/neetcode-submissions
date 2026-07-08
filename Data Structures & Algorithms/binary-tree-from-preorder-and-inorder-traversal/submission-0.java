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
    HashMap<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recursive(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode recursive(int[] preorder, int[] inorder, int prestart, int preend, int inStart, int inEnd) {
        if (prestart > preend) {
            return null;
        } else {
            int i = map.get(preorder[prestart]);
            int k = i - inStart;

            TreeNode root = new TreeNode(preorder[prestart]);

            root.left = recursive(preorder, inorder, prestart + 1, prestart + k, inStart, i - 1);
            root.right = recursive(preorder, inorder, prestart + k + 1, preend, i + 1, inEnd);
            return root;
        }
    }
}
