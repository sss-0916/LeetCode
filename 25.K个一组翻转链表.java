/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        
        ListNode dummyNode = new ListNode(-1);
        ListNode tailNode = dummyNode;

        ListNode curNode = head;
        while (curNode != null) {
            stack.push(curNode);

            if (stack.size() != k) {
                curNode = curNode.next;
                continue;
            }

            ListNode nextNode = stack.peek().next;
            stack.peek().next = null;
            while (!stack.isEmpty()) {
                tailNode.next = stack.pop();
                tailNode = tailNode.next;
            }
            curNode = nextNode;
        }

        while (stack.size() > 1) {
            stack.pop();
        }
        tailNode.next = stack.isEmpty() ? null : stack.pop();

        return dummyNode.next;
    }
}