/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        HashMap<Integer, ListNode> map = new HashMap<>();
        int sum = 0;
        for (ListNode curNode = dummyNode; curNode != null; curNode = curNode.next) {
            sum += curNode.val;
            map.put(sum, curNode);
        }

        sum = 0;
        for (ListNode curNode = dummyNode; curNode != null; curNode = curNode.next) {
            sum += curNode.val;
            curNode.next = map.get(sum).next;
        }

        return dummyNode.next;
    }
}