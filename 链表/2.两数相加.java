/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode dummyNode = new ListNode(-1);
        ListNode tailNode = dummyNode;
        ListNode curL1 = l1, curL2 = l2;
        int num1 = 0, num2 = 0, carry = 0, sum = 0;
        while (curL1 != null || curL2 != null || carry != 0) {
            num1 = curL1 == null ? 0 : curL1.val;
            num2 = curL2 == null ? 0 : curL2.val;
            sum = num1 + num2 + carry;
            carry = sum / 10;

            tailNode.next = new ListNode(sum % 10);
            tailNode = tailNode.next;

            curL1 = curL1 == null ? null : curL1.next;
            curL2 = curL2 == null ? null : curL2.next;
        }
        tailNode.next = null;

        return dummyNode.next;
    }
}