/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int numComponents(ListNode head, int[] G) {
        HashSet<Integer> set = new HashSet<>();
        for (int g : G) set.add(g);

        int result = 0;
        for (ListNode curNode = head; curNode != null; curNode = curNode.next) {
            result += (
                set.contains(curNode.val) &&
                (curNode.next == null || !set.contains(curNode.next.val))
            ) ? 1 : 0;
        }

        return result;
    }
}