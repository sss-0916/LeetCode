/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode dummyNode = new ListNode(-1);
        ListNode tailNode = dummyNode;
        for (ListNode curNode = head; curNode != null; curNode = curNode.next) {
            if (curNode.val != val) {
                tailNode.next = curNode;
                tailNode = curNode;
            }
        }
        tailNode.next = null;

        return dummyNode.next;
    }
}