/* LeetCode 129. Sum Root to Leaf Numbers */

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
    public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }

    /**
     * Recursively calculates the sum from a node to leaf. 
     * 
     * @param node The current node.
     * @param sum The current sum.
     * @return The sum from the node to leaf. 
     */
    private int sum(TreeNode node, int sum) {
        if (node == null) return 0;

        // Updates the sum (with digits in reverse order)
        sum = (sum * 10) + node.val;
        if (node.left == null && node.right == null) return sum;

        // Recursively calculates the total for left and right subtrees
        return sum(node.left, sum) + sum(node.right, sum);
    }
}