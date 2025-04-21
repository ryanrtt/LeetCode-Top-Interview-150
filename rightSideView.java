/* LeetCode 199. Binary Tree Right Side View */

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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();
        
        List<Integer> list = new ArrayList<>();

        // Queue for BFS traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // BFS traversal
        while (!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.remove();

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);

                // If i is equal to count - 1, this must be the last node on the level, so add to the list
                if (i == count - 1) list.add(node.val);
            }
        }

        return list;
    }
}