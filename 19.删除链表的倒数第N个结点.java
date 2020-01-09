/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) return head;

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode firstNode = dummyNode;
        for (int i = 0; i < n + 1; ++i) {
            if (firstNode == null) {
                return head;
            }
            firstNode = firstNode.next;
        }
        ListNode secondNode = dummyNode;
        while (firstNode != null) {
            firstNode = firstNode.next;
            secondNode = secondNode.next;
        }

        secondNode.next = secondNode.next.next;

        return dummyNode.next;
    }
}