/* LeetCode 104. Maximum Depth of Binary Tree */

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
    public int maxDepth(TreeNode root) {
        return depth(root, 1);
    }

    /**
     * Finds the maximum depth rooted at a node. 
     * 
     * @param node The current node.
     * @param depth The current depth.
     * @return The height of the node.
     */
    private int depth(TreeNode node, int depth) {
        if (node == null) return depth - 1;

        // Traverse and find the max depth of the left and right subtrees
        return Math.max(depth(node.left, depth + 1), depth(node.right, depth + 1));
    }
}