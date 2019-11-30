/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode fastNode = head, slowNode = head;
        while (true) {
            if (fastNode == null || fastNode.next == null) {
                break;
            }
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }

        return slowNode;
    }
}