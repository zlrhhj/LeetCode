class ListNode{
    int val;
    ListNode next;
    ListNode(){};
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val,ListNode next) {
        this.val = val;
        this.next = next;
    }
}
public class ReverseLinkedList {
    public ListNode reverserList(ListNode head) {
        if(head == null) {
            return head;
        }
        ListNode curNode = head;
        ListNode preNode = null;
        while(curNode != null) {
            ListNode nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }
        return preNode;
    }
}
