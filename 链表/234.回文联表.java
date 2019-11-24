/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode fastNode = head, slowNode = head;
        while (true) {
            if (fastNode == null || fastNode.next == null) {
                break;
            }
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }

        ListNode curNode = slowNode.next;
        slowNode.next = null;
        while (curNode != null) {
            ListNode nextNode = curNode.next;

            curNode.next = slowNode;
            slowNode = curNode;

            curNode = nextNode;
        }

        fastNode = head;
        while (slowNode != null) {
            if (slowNode.val != fastNode.val) {
                return false;
            }
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        return true;
    }
}