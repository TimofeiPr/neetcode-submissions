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
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null) {
            return null;
        }

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        ListNode dummy = new ListNode();
        ListNode front = null;
        
        for (ListNode list : lists) {
            pq.add(list);
        }

        int  i = 0;
        while (!pq.isEmpty()) {
            System.out.println(i);
            i++;
            ListNode temp = pq.remove();

            if (temp.next != null) {
                pq.add(temp.next);
            }

            if (front == null) {
                front = temp;
                dummy.next = front;
            } else {
                front.next = temp;
                front = temp;
            }
        }
        
        return dummy.next;
    }
}
