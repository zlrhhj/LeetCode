public class DeleteMiddleNode {
    //Attempt #1 using fast and slow pointer;
    public ListNode deleteMiddle( ListNode head ) {
        if(head == null || head.next == null) return null;
        ListNode slow = head, fast = head.next.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
