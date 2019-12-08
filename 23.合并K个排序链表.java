/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode list : lists) {
            if (list != null) {
                queue.offer(list);
            }
        }

        ListNode dummyNode = new ListNode(-1);
        ListNode tailNode = dummyNode;
        while (!queue.isEmpty()) {
            tailNode.next = queue.poll();
            tailNode = tailNode.next;
            if (tailNode.next != null) {
                queue.offer(tailNode.next);
            }
        }

        return dummyNode.next;
    }
}