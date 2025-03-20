class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class CopyLinkedListWithRandomPointer {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node ptr = head;
        while(ptr != null) {
            Node newNode = new Node(ptr.val);
            newNode.next = ptr.next;
            ptr.next = newNode;
            ptr = newNode.next;
        }
        ptr = head;
        while(ptr != null) {
            ptr.next.random = ptr.random != null ? ptr.random.next : null;
            ptr = ptr.next.next;
        }
        Node newHead = head.next;
        Node newPtr = newHead;
        ptr = head;
        while(ptr != null) {
            ptr.next = newPtr.next;
            ptr = ptr.next;
            newPtr.next = ptr != null ? ptr.next : null;
            newPtr = newPtr.next;
        }
        return newHead;
    }
}
