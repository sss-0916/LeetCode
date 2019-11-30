/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ArrayList<ListNode> list = new ArrayList<>();
        for (ListNode curNode = head; curNode != null; curNode = curNode.next) {
            list.add(curNode);
        }

        int left = 0, right = list.size() - 1;
        while (left < right) {
            list.get(left++).next = list.get(right);

            if (left == right) break;

            list.get(right--).next = list.get(left);
        }
        list.get(left).next = null;
    }
}