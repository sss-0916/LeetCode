/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode result = null;
        ListNode curNode = head;
        while (curNode != null) {
            ListNode nextNode = curNode.next;

            curNode.next = result;
            result = curNode;

            curNode = nextNode;
        }

        return result;
    }
}