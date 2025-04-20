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
        ArrayList<Integer> list = inOrder(root, k, new ArrayList<>());

        return list.get(--k);
    }

    private ArrayList<Integer> inOrder(TreeNode node, int k, ArrayList<Integer> list) {
        if (node == null) return list;

        inOrder(node.left, k, list);

        if (list.size() == k) return list;
        list.add(node.val);

        inOrder(node.right, k, list);

        return list;
    }
}