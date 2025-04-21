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

    int pointer; // Pointer to get retrieve current iteration
    ArrayList<Integer> nodes; // To store all nodes in the BST

    /**
     * Constructor to begin with an in-order traversal to get the nodes in sorted order, and set the pointer to -1.
     * 
     * @param root The root of the tree.
     */
    public BSTIterator(TreeNode root) {
        this.pointer = -1;
        this.nodes = inOrder(root, new ArrayList<>());
    }
    
    /*
     * Gets the next value within the iterator.
     * 
     * @return The value of the node next in the iterator.
     */
    public int next() {
        return nodes.get(++pointer);
    }
    
    /**
     * Gets whether the iterator has a next item.
     * 
     * @return <code>true</code> if the iterator has a next item, <code>false</code> otherwise.
     */
    public boolean hasNext() {
        return pointer < nodes.size() - 1;
    }

    /**
     * Recursively creates the list of the in-order traversal of the BST.
     * 
     * @param node The current node.
     * @param list The list of nodes of the in-order traversal.
     * @return The list of nodes of the in-order traversal.
     */
    private ArrayList<Integer> inOrder(TreeNode node, ArrayList<Integer> list) {
        if (node == null) return list;

        // Traverse left sub-tree
        inOrder(node.left, list);

        // Add node value onto the list
        list.add(node.val);

        // Traverse right sub-tree
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