/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || n - m <= 0) {
            return head;
        }
        
        ListNode cur = head;
        for (int i = 0; i < m - 1; ++i) {
            cur = cur.next;
        }
        ListNode temp = cur;
        
        Stack<Integer> stack = new Stack<>();
        for (int i = m; i <= n; ++i) {
            stack.push(cur.val);
            cur = cur.next;
        }
        
        cur = temp;
        for (int i = m; i <= n; ++i) {
            cur.val = stack.pop();
            cur = cur.next;
        }
        
        return head;
    }
}