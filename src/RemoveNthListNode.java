public class RemoveNthListNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode node = head;
        while(node != null) {
            len++;
            node = node.next;
        }
        node = head;
        int index = 0;
        if(len - n == 0) {
            head = head.next;
            return head;
        }
        while(index < len - n - 1) {
            node = node.next;
            index++;
        }
        node = node.next.next;
        return head;
    }
}
