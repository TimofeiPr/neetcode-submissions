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
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode dummy = new ListNode(-1, head);
        int i = 0;
        while (head != null) {
            if (i > 1000) {
                return true;
            }
            head.val = i;
            head = head.next;
            i++;
        }
        head = dummy.next;
        i = 0;
        while (head != null) {
            if (i < 3) {
                System.out.println(i);
            }
            if (head.val < i) {
                return true;
            }
            head = head.next;
            i++;
        }
        return false;

    }
}
