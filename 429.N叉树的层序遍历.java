/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            List<Integer> curLevel = new LinkedList<>();
            for (int i = 0; i < qSize; ++i) {
                Node curNode = queue.poll();
                curLevel.add(curNode.val);
                for (Node child : curNode.children) {
                    queue.offer(child);
                }
            }
            result.add(curLevel);
        }

        return result;
    }
}