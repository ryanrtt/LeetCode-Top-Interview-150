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
        List<Integer> list = inOrder(root, new ArrayList<>());

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list.size() - 1; i++) {
            min = Math.min(min, list.get(i + 1) - list.get(i));
        }

        return min;
    }

    private List<Integer> inOrder(TreeNode node, ArrayList<Integer> list) {
        if (node == null) return list;

        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);

        return list; 
    }
}