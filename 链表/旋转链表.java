/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k <= 0) {
            return head;
        }

        int size = 0;
        ListNode curNode = head;
        while (curNode.next != null) {
            ++size;
            curNode = curNode.next;
        }
        ++size;
        curNode.next = head;

        curNode = head;
        k %= size;
        int steps = size - k - 1;
        for (int i = 0; i < steps; ++i) {
            curNode = curNode.next;
        } 
        ListNode result = curNode.next;
        curNode.next = null;

        return result;
    }
}