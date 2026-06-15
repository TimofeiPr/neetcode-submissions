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
    public void reorderList(ListNode head) {
        Deque<ListNode> deque = new ArrayDeque<>();

        while (head != null) {
            deque.addLast(head);
            head = head.next;
        }

        ListNode tail = deque.pollFirst(); 

        while (!deque.isEmpty()) {
            tail.next = deque.pollLast();
            tail = tail.next; 
            if (!deque.isEmpty()) {
                tail.next = deque.pollFirst();
                tail = tail.next; 
            }
        }
        
        tail.next = null;
    }
}
