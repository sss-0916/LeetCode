class MyLinkedList {
    static class ListNode {
        public int val;
        public ListNode prev = null;
        public ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    private ListNode head = null;
    private int size = 0;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        this.head = new ListNode(-1);
        this.head.next = this.head;
        this.head.prev = this.head;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0 || index >= this.size) {
            return -1;
        }

        ListNode curNode = this.head;
        for (int i = 0; i < index; ++i) {
            curNode = curNode.next;
        }

        return curNode.next.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        ++this.size;
        
        newNode.next = this.head.next;
        newNode.prev = this.head;
        this.head.next.prev = newNode;
        this.head.next = newNode;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);
        ++this.size;

        newNode.next = this.head;
        newNode.prev = this.head.prev;
        this.head.prev.next = newNode;
        this.head.prev = newNode;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > this.size) {
            return;
        }

        if (index <= 0) {
            this.addAtHead(val);
            return;
        }
        if (index == this.size) {
            this.addAtTail(val);
            return;
        }

        ListNode prevNode = this.head;
        for (int i = 0; i < index; ++i) {
            prevNode = prevNode.next;
        }
        ListNode newNode = new ListNode(val);
        newNode.next = prevNode.next;
        newNode.prev = prevNode;
        prevNode.next.prev = newNode;
        prevNode.next = newNode;
        ++this.size;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= this.size) {
            return;
        }

        ListNode curNode = this.head;
        for (int i = 0; i <= index; ++i) {
            curNode = curNode.next;
        }
        curNode.next.prev = curNode.prev;
        curNode.prev.next = curNode.next;
        --this.size;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */