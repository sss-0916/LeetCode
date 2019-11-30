/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        
        HashSet<ListNode> set = new HashSet<>();
        for (ListNode curNode = head; curNode != null; curNode = curNode.next) {
            if (set.contains(curNode)) {
                return curNode;
            }
            set.add(curNode);
        }
        return null;
    }
}