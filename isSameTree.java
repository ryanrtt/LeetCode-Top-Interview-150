/* LeetCode 100. Same Tree */

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
        return same(p, q);
    }   

    /**
     * Finds whether two binary trees are the same.
     *  
     * @param node1 The node of the first binary tree.
     * @param node2 The node of the second binary tree.
     * @return <code>true</code> if the two trees are the same, <code>false</code> otherwise.
     */
    private boolean same(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true; 
        
        // If one node is exclusively null
        if (node1 == null ^ node2 == null) return false;

        // If the node values do not match
        if (node1.val != node2.val) return false;

        // Traverse left and right subtrees.
        return same(node1.left, node2.left) && same(node1.right, node2.right);
    }
}