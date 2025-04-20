/* LeetCode 112. Path Sum */

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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return walk(root, 0, targetSum);
    }

    private boolean walk(TreeNode node, int sum, int targetSum) {
        if (node == null) return false;

        sum += node.val;
        if (sum == targetSum && node.left == null && node.right == null) return true;

        return walk(node.left, sum, targetSum) || walk(node.right, sum, targetSum);
    }
}