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

        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        ListNode curNode = null;

        for (curNode = l1; curNode != null; curNode = curNode.next) {
            s1.push(curNode);
        }
        for (curNode = l2; curNode != null; curNode = curNode.next) {
            s2.push(curNode);
        }

        ListNode result = null;
        int carry = 0;
        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
            int num1 = s1.isEmpty() ? 0 : s1.pop().val;
            int num2 = s2.isEmpty() ? 0 : s2.pop().val;
            int sum = num1 + num2 + carry;
            carry = sum / 10;

            ListNode newNode = new ListNode(sum % 10);
            newNode.next = result;
            result = newNode;
        }

        return result;
    }
}