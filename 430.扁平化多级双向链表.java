/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
class Solution {
    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }

        Node curNode = head;
        while (curNode != null) {
            if (curNode.child != null) {
                Node nextNode = curNode.next;
                Node child = flatten(curNode.child);
                curNode.next = child;
                child.prev = curNode;
                curNode.child  = null;

                if (nextNode != null) {
                    while (curNode.next != null) {
                        curNode = curNode.next;
                    }
                    curNode.next = nextNode;
                    nextNode.prev = curNode;
                }
            }
            curNode = curNode.next;
        }

        return head;
    }
}