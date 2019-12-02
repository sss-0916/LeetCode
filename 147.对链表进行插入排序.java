/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = null;

        ListNode result = dummyNode;
        ListNode curNode = head;
        while (curNode != null) {
            while (result.next != null && result.next.val <= curNode.val) {
                result = result.next;
            }

            ListNode nextNode = curNode.next;

            curNode.next = result.next;
            result.next = curNode;

            curNode = nextNode;
            result = dummyNode;
        }

        return dummyNode.next;
    }
}