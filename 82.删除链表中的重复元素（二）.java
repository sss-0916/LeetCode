/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyNode = new ListNode(-1);
        ListNode tailNode = dummyNode;
        for (ListNode curNode = head; curNode != null; curNode = curNode.next) {
            if (curNode.next != null && curNode.val == curNode.next.val) {
                while (curNode.next != null && curNode.val == curNode.next.val) {
                    curNode = curNode.next;
                }
            } else {
                tailNode.next = curNode;
                tailNode = curNode;
            }
        }
        tailNode.next = null;

        return dummyNode.next;
    }
}