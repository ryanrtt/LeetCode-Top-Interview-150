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

        ListNode dummy = head;
        while (dummy.next != null) {
            length++;
            dummy = dummy.next;
        }

        length++;
        dummy.next = head;
        dummy = head;

        int shift = (k % length) + 1;
        int count = 0;
        while (count < length - shift) {
            count++;
            dummy = dummy.next;
        }

        ListNode temp = dummy.next;
        dummy.next = null;

        return temp;
    }
}