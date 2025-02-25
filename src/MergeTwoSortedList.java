public class MergeTwoSortedList {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode tail = head;
        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                ListNode temp = list1.next;
                tail.next = list1;
                list1 = temp;
                tail = tail.next;
            }
        }
        if(list1 != null) {
            tail.next = list1;
        }
        if(list2 != null) {
            tail.next = list2;
        }
        return head.next;
    }
}
