/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode oddHead = new ListNode(-1);
        ListNode evenHead = new ListNode(-1);
        ListNode oddTail = oddHead, evenTail = evenHead;
        boolean flag = true;
        for (ListNode curNode = head; curNode != null; curNode = curNode.next) {
            if (flag) {
                oddTail.next = curNode;
                oddTail = curNode;
            } else {
                evenTail.next = curNode;
                evenTail = curNode;
            }
            flag = !flag;
        }
        oddTail.next = evenHead.next;
        evenTail.next = null;

        return oddHead.next;
    }
}