/* LeetCode 114. Flatten Binary Tree to Linked List */

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
    public void flatten(TreeNode root) {
        if (root == null) return;

        // Perform a pre-order traversal of the tree
        List<TreeNode> list = preOrder(root, new ArrayList<>());
        int size = list.size() - 1;

        // Set each left pointer to null, and each right pointer to the next node in the list
        for (int i = 0; i < size; i++) {
            list.get(i).left = null;
            list.get(i).right = list.get(i + 1);
        }

        // Set the both the last node's pointers to null
        list.get(size).left = null;
        list.get(size).right = null;
    }

    /**
     * Recursively performs a pre-order traversal of the tree.
     * 
     * @param node The current node.
     * @param list The list of nodes of the pre-order traversal.
     * @return The list of nodes of the pre-order traversal.
     */
    private ArrayList<TreeNode> preOrder(TreeNode node, ArrayList<TreeNode> list) {
        if (node == null) return list;

        // Add node to the list
        list.add(node);

        // Traverse left sub-tree
        preOrder(node.left, list);

        // Traverse right sub-tree
        preOrder(node.right, list);

        return list;
    }
}