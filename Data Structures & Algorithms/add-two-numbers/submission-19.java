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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean overTen = false;
        boolean firstNull = true;
        ListNode dummy = new ListNode();
        dummy.next = l1;

        ListNode prev = new ListNode();

        while (l1 != null || l2 != null) {
            if (l2 == null) {
                l2 = new ListNode(0);
            } else if (l1 == null) {
                l1 = new ListNode(l2.val);
                if (firstNull) {
                    firstNull = false;
                    prev.next = l1;
                }
            } else {
                l1.val = l1.val + l2.val;
            }

            if (overTen) {
                l1.val++;
                overTen = false;
            }

            if (l1.val > 9) {
                overTen = true;
                l1.val = l1.val - 10;
            } 

            if (l1.next == null && overTen && l2.next == null) {
                ListNode end = new ListNode(1);
                l1.next = end;
                System.out.print(l1.val);
                System.out.print(l1.next.val);
                return dummy.next;
            }

            if (l1.next == null && firstNull) {
                prev = l1;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        System.out.print("Outside Loop");
        return dummy.next;
    }
}
