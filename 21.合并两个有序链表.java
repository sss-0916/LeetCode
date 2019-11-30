/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode dummyNode = new ListNode(-1);
        ListNode tailNode = dummyNode;
        ListNode curL1 = l1, curL2 = l2;
        while (curL1 != null && curL2 != null) {
            if (curL1.val <= curL2.val) {
                tailNode.next = curL1;
                tailNode = curL1;
                curL1 = curL1.next;
            } else {
                tailNode.next = curL2;
                tailNode = curL2;
                curL2 = curL2.next;
            }
        }
        tailNode.next = curL1 == null ? curL2 : curL1;

        return dummyNode.next;
    }
}