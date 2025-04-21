/* LeetCode 226. Invert Binary Tree */

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

    /**
     * Inverts a binary tree by swapping each node's left and right pointers.
     * 
     * @param node The current node to invert.
     * @return The root node of the inversion.
     */
    private TreeNode invert(TreeNode node) {
        if (node == null) return node;

        // Create a temporary variable for swapping
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

        // Invert the left and right children after swapping
        invert(node.left);
        invert(node.right);

        return node;
    }
}