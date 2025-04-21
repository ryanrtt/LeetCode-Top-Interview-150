/* LeetCode 637. Average of Levels in Binary Tree */

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
    public List<Double> averageOfLevels(TreeNode root) {
        // Queue for BFS traversal
        Queue<TreeNode> queue = new ArrayDeque<>();

        // List to store the average value of nodes at each level
        List<Double> list = new ArrayList<>();
        queue.offer(root);

        // BFS traversal
        while(!queue.isEmpty()) {
            double sum = 0;
            int length = queue.size();

            // Iterate through all nodes at the current level and get the total sum
            for (int i = 0; i < length; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            // Add the average of the level to the list
            list.add(sum / length);
        }

        return list;
    }
}