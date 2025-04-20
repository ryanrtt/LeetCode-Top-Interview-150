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

        List<TreeNode> list = preOrder(root, new ArrayList<>());
        int size = list.size() - 1;

        for (int i = 0; i < size; i++) {
            list.get(i).left = null;
            list.get(i).right = list.get(i + 1);
        }

        list.get(size).left = null;
        list.get(size).right = null;
    }

    private ArrayList<TreeNode> preOrder(TreeNode node, ArrayList<TreeNode> list) {
        if (node == null) return list;

        list.add(node);
        preOrder(node.left, list);
        preOrder(node.right, list);

        return list;
    }
}