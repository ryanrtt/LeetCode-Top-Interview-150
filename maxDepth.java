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

    private int depth(TreeNode node, int depth) {
        if (node == null) return depth - 1;

        return Math.max(depth(node.left, depth + 1), depth(node.right, depth + 1));
    }
}