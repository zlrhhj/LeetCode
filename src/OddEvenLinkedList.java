public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return null;
        ListNode even = head.next;
        ListNode odd = head;
        ListNode evenHead = even;
        while( even != null && even.next != null ) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
