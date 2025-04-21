/* LeetCode 98. Validate Binary Search Tree */

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
    public boolean isValidBST(TreeNode root) {
        // Performs an in-order traversal of the tree
        ArrayList<Integer> list = inOrder(root, new ArrayList<>());

        // Iterate through the in-order traversal and return false if the current value has the same or greater value than the next 
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) return false;
        }

        return true;
    } 

    /**
     * Recursively creates the list of the in-order traversal of the BST.
     * 
     * @param node The current node.
     * @param list The list of nodes of the in-order traversal.
     * @return The list of nodes of the in-order traversal.
     */
    private ArrayList<Integer> inOrder(TreeNode node, ArrayList<Integer> list) {
        if (node == null) return list;

        // Traverse left sub-tree
        inOrder(node.left, list);

        // Add node value onto the list
        list.add(node.val);

        // Traverse right sub-tree
        inOrder(node.right, list);

        return list;
    }
}