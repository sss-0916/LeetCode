/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private List<Integer> list = new ArrayList<>();

    private void convertToList(ListNode head) {
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
    }

    private TreeNode convertToBST(int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(this.list.get(mid));
        root.left = convertToBST(left, mid - 1);
        root.right = convertToBST(mid + 1, right);

        return root;
    }

    public TreeNode sortedListToBST(ListNode head) {
        convertToList(head);

        return convertToBST(0, list.size() - 1);
    }
}