/* LeetCode 61. Rotate List */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null) return head;
        int length = 0;

        // Traverse through entire linked list until penultimate node
        ListNode dummy = head;
        while (dummy.next != null) {
            length++;
            dummy = dummy.next;
        }
        length++;

        // Set the final node's pointer to the head of the list to create a cycle
        dummy.next = head;
        dummy = head;

        // Calculate shift position
        int shift = (k % length) + 1;
        int count = 0;

        // Get the position of the new end node 
        while (count < length - shift) {
            count++;
            dummy = dummy.next;
        }

        // Set the final node's pointer to null after shifting 
        ListNode temp = dummy.next;
        dummy.next = null;

        return temp;
    }
}