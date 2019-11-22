/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode curNode = dummyNode;
        while (curNode.next != null && curNode.next.next != null) {
            ListNode leftNode = curNode.next;
            ListNode rightNode = curNode.next.next;

            leftNode.next = rightNode.next;
            rightNode.next = leftNode;

            curNode.next = rightNode;
            curNode = leftNode;
        }

        return dummyNode.next;
    }
}