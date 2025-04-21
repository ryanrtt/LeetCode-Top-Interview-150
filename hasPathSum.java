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

    /**
     * Recursively traverses down the tree to see if there is a root-to-leaf path of nodes which add to the target value. 
     * 
     * @param node The current node.
     * @param sum The current sum.
     * @param targetSum The target sum.
     * @return <code>true</code> if there is a root-to-leaf path of nodes which add to the target value <code>false</code> otherwise.
     */
    private boolean walk(TreeNode node, int sum, int targetSum) {
        if (node == null) return false;

        sum += node.val;

        // Check if the node is a leaf and has the target sum. 
        if (sum == targetSum && node.left == null && node.right == null) return true;

        // Traverse left and right subtrees
        return walk(node.left, sum, targetSum) || walk(node.right, sum, targetSum);
    }
}