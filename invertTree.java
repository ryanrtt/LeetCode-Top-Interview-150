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
    public TreeNode invertTree(TreeNode root) {
        return invert(root);
    }

    private TreeNode invert(TreeNode node) {
        if (node == null) return node;

        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

        invert(node.left);
        invert(node.right);

        return node;
    }
}