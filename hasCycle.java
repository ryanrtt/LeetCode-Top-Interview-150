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
        HashSet<ListNode> hash = new HashSet<>();

        while (head != null) {
            if (!hash.add(head)) return true;
            head = head.next;
        }

        return false;
    }
}