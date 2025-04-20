/* LeetCode 103. Binary Tree Zigzag Level Order Traversal */

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<List<Integer>>();

        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        Deque<TreeNode> deque = new LinkedList<>();

        boolean reverse = false;

        deque.addFirst(root);
        while (!deque.isEmpty()) {
            int count = deque.size();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < count; i++) {
                TreeNode node = reverse ? deque.removeLast() : deque.removeFirst();

                if (reverse) {
                    if (node.right != null) deque.addFirst(node.right);
                    if (node.left != null) deque.addFirst(node.left);
                } else {
                    if (node.left != null) deque.addLast(node.left);
                    if (node.right != null) deque.addLast(node.right);
                }

                list.add(node.val);
            }

            answer.add(list);
            reverse = !reverse;
        }
        
        return answer;
    }
}