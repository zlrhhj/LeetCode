public class ReorderList {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        slow.next = null;
        ListNode second = slow.next;
        ListNode reversedSecond = null;
        while(second != null) {
            ListNode temp = second.next;
            second.next = reversedSecond;
            reversedSecond = second;
            second = temp;
        }
        second = reversedSecond;
        ListNode first = head;
        while(second != null) {
            ListNode firstTail = first.next;
            first.next = second;
            second = second.next;
            first.next.next = firstTail;
            first = firstTail;
        }
    }
}
