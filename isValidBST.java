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
        ArrayList<Integer> list = inOrder(root, new ArrayList<>());

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) return false;
        }

        return true;
    } 

    private ArrayList<Integer> inOrder(TreeNode node, ArrayList<Integer> list) {
        if (node == null) return list;

        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);

        return list;
    }
}