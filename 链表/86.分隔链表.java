/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode smallHead = new ListNode(-1);
        ListNode largeHead = new ListNode(-1);
        ListNode smallTail = smallHead, largeTail = largeHead;
        for (ListNode curNode = head; curNode != null; curNode = curNode.next) {
            if (curNode.val < x) {
                smallTail.next = curNode;
                smallTail = curNode;
            } else {
                largeTail.next = curNode;
                largeTail = curNode;
            }
        }
        smallTail.next = largeHead.next;
        largeTail.next = null;

        return smallHead.next;
    }
}