/* LeetCode 117. Populating Next Right Pointers in Each Node II */

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) return root;

        // Queue for BFS traversal
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        // BFS traversal 
        while (!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                Node node = queue.poll();

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);

                // Set each next pointer to the current head of the queue, null for last node of the level
                node.next = i != count - 1 ? queue.peek() : null;
            }
        } 

        return root;
    }
}