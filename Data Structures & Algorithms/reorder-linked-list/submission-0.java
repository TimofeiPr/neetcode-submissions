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

        // 3. Alternate pulling from back and front
        while (!deque.isEmpty()) {
            // Pull from the back and attach
            tail.next = deque.pollLast();
            tail = tail.next; // Move the tail tracker forward

            // Pull from the front and attach (if there are nodes left)
            if (!deque.isEmpty()) {
                tail.next = deque.pollFirst();
                tail = tail.next; // Move the tail tracker forward
            }
        }
        
        // 4. The Magic Fix: Safely cap the end of the list
        tail.next = null;
    }
}
