/** LeetCode 530. Minimum Absolute Difference in BST */

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
    public int getMinimumDifference(TreeNode root) {
        // Perform an in-order traversal of the tree
        List<Integer> list = inOrder(root, new ArrayList<>());

        // Set minimum value to an arbitrarily large value
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list.size() - 1; i++) {
            // Get the minimum between sorted values
            min = Math.min(min, list.get(i + 1) - list.get(i));
        }

        return min;
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