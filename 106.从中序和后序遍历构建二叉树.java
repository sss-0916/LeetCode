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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] in, int iStart, int iEnd, int[] post, int pStart, int pEnd) {
        if (iStart > iEnd || pStart > pEnd) {
            return null;
        }

        int rootVal = post[pEnd], rootIndex = -1;
        while (in[++rootIndex] != rootVal);
        int leftSize = rootIndex - iStart;

        TreeNode root = new TreeNode(rootVal);
        root.left = build(in, iStart, rootIndex - 1, post, pStart, pStart + leftSize - 1);
        root.right = build(in, rootIndex + 1, iEnd, post, pStart + leftSize, pEnd - 1);

        return root;
    }
}