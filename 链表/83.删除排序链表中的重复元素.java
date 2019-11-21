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
        if (head == null || head.next == null) return head;

        ListNode result = head;
        ListNode tailNode = head;
        for (ListNode curNode = head.next; curNode != null; curNode = curNode.next) {
            if (curNode.val != tailNode.val) {
                tailNode.next = curNode;
                tailNode = curNode;
            }
        }
        tailNode.next = null;
        
        return result;
    }
}