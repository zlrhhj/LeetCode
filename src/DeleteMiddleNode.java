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
    //Atempt #2 using 2 passses
    public ListNode deleteMiddle( ListNode head ) {
        if( head == null || head.next == null ) return null;
        int count = 0;
        ListNode current = head;
        if( current != null ) {
            count++;
            current = current.next;
        }
        count = count / 2;
        current = head;
        while( count > 1 ) {
            current = current.next;
            count--;
        }
        current.next = current.next.next;
        return head;
    }
}
