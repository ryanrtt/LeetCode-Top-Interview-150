/* LeetCode 102. Binary Tree Level Order Traversal */

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<List<Integer>>();

        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int count = queue.size();

            for (int i = 0; i < count; i++) {
                TreeNode node = queue.peek();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);

                list.add(queue.remove().val);
            }
            
            answer.add(list);
        }

        return answer;
    }
}