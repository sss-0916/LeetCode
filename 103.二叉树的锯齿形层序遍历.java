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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isReverse = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> curLevel = new LinkedList<>();
            for (int i = 0; i < size; ++i) {
                TreeNode curNode = queue.poll();
                if (!isReverse) {
                    curLevel.add(curNode.val);
                } else {
                    curLevel.add(0, curNode.val);
                }
                
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }
            isReverse = !isReverse;
            result.add(curLevel);
        }
        
        return result;
    }
}