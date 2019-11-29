/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        for (Node curNode = head; curNode != null; curNode = curNode.next) {
            map.put(curNode, new Node(curNode.val, null, null));
        }

        for (Node curNode = head; curNode != null; curNode = curNode.next) {
            map.get(curNode).next = map.get(curNode.next);
            map.get(curNode).random = map.get(curNode.random);
        }

        return map.get(head);
    }
}