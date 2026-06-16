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
        if (head.next == null) {
            return null;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        for (int i = 0; i < n; i++) {
            head = head.next;
        }
        ListNode middle = dummy.next;
        ListNode prev = new ListNode();
        if (head == null) {
            return dummy.next.next;
        }
        head = head.next;
        middle = middle.next;
        prev = dummy.next;

        while (head != null) {
            head = head.next;
            middle = middle.next;
            prev = prev.next;
        }

        prev.next = middle.next;

        return dummy.next;
    }
}
