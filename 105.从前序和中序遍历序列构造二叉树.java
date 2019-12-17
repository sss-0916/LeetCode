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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] pre, int pStart, int pEnd, int[] in, int iStart, int iEnd) {
        if (pStart > pEnd || iStart > iEnd) {
            return null;
        }

        int rootVal = pre[pStart], rootIndex = -1;
        while (in[++rootIndex] != rootVal);
        int leftSize = rootIndex - iStart;

        TreeNode root = new TreeNode(rootVal);
        root.left = build(pre, pStart + 1, pStart + leftSize, in, iStart, rootIndex - 1);
        root.right = build(pre, pStart + leftSize + 1, pEnd, in, rootIndex + 1, iEnd);

        return root;
    }
}