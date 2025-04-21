/* LeetCode 230. Kth Smallest Element in a BST */

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
    public int kthSmallest(TreeNode root, int k) {
        // Performs an in-order traversal of the tree
        ArrayList<Integer> list = inOrder(root, k, new ArrayList<>());

        return list.get(--k);
    }

    /**
     * Recursively creates the list of the in-order traversal of the BST, until the kth smallest element.
     * 
     * @param node The current node.
     * @param k The kth smallest element to be found.
     * @param list The list of nodes of the in-order traversal.
     * @return The list of nodes of the in-order traversal.
     */
    private ArrayList<Integer> inOrder(TreeNode node, int k, ArrayList<Integer> list) {
        if (node == null) return list;

        // Traverse left sub-tree
        inOrder(node.left, k, list);

        // If k elements have been found
        if (list.size() == k) return list;

        // Add node value onto the list
        list.add(node.val);

        // Traverse right sub-tree
        inOrder(node.right, k, list);

        return list;
    }
}