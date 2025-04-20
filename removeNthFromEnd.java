/* LeetCode 19. Remove Nth Node From End of List */

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> list = new ArrayList<>();

        int count = 0;
        ListNode dummy = head;
        while (dummy != null) {
            count++;
            list.add(dummy);
            dummy = dummy.next;
        }

        if (count == n) return head.next;
        list.get(count - 1 - n).next = list.get(count - n).next;

        return head;
    }
}