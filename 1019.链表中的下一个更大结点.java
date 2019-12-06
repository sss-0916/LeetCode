/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        Stack<Integer> input = new Stack<>();
        int size = 0;
        for (ListNode curNode = head; curNode != null; curNode = curNode.next) {
            input.push(curNode.val);
            ++size;
        }

        int[] result = new int[size];
        Stack<Integer> monotonicStack = new Stack<>();
        while (!input.isEmpty()) {
            while (!monotonicStack.isEmpty() && monotonicStack.peek() <= input.peek()) {
                monotonicStack.pop();
            }

            result[--size] = monotonicStack.isEmpty() ? 0 : monotonicStack.peek();

            monotonicStack.push(input.pop());
        }

        return result;
    }
}