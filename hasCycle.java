/* 141. Linked List Cycle */

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // Create a new hashset to store all encountered nodes
        HashSet<ListNode> hash = new HashSet<>();

        while (head != null) {
            // If the node could not be added, it means it has already been added
            if (!hash.add(head)) return true;
            head = head.next;
        }

        return false;
    }
}