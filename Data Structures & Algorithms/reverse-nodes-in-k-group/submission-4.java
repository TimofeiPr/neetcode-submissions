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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int count = 0;

        Stack<ListNode> stack = new Stack<ListNode>();

        ListNode dummy = new ListNode();
        ListNode front = new ListNode();
        
        dummy.next = front;

        while (head != null) {
            count++;
            stack.push(head);
            head = head.next;

            if (count == k) {
                count = 0;
                front.next = stack.peek();
                ListNode temp = null; 
                while (!stack.isEmpty()) {
                    temp = stack.pop();
                    if (!stack.isEmpty()) {
                        temp.next = stack.peek();
                    } else {
                        temp.next = head;
                    }   
                } 
                front = temp;
            }
        }

        return dummy.next.next;
    }
}