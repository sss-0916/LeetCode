/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        int size = 0;
        ListNode curNode = root;
        for (; curNode != null; curNode = curNode.next) {
            ++size;
        }

        int width = size / k; 
        int rem = size % k;
        
        int index = 0;
        curNode = root;
        ListNode[] result = new ListNode[k];
        for (int i = 0; i < k; ++i) {
            result[index++] = curNode;
            for (int j = 0; j < width + (i < rem ? 1 : 0) - 1; ++j) {
                if (curNode != null) {
                    curNode = curNode.next;
                }
            }
            if (curNode != null) {
                ListNode nextNode = curNode.next;
                curNode.next = null;
                curNode = nextNode;
            }
        }

        return result;
    }
}