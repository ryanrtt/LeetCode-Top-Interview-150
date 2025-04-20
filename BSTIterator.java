/* LeetCode 173. Binary Search Tree Iterator */

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
class BSTIterator {

    int pointer;
    ArrayList<Integer> nodes;

    public BSTIterator(TreeNode root) {
        this.pointer = -1;
        this.nodes = inOrder(root, new ArrayList<>());
    }
    
    public int next() {
        return nodes.get(++pointer);
    }
    
    public boolean hasNext() {
        return pointer < nodes.size() - 1;
    }

    private ArrayList<Integer> inOrder(TreeNode node, ArrayList<Integer> list) {
        if (node == null) return list;

        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);

        return list;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */