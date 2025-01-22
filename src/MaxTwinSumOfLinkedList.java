import java.util.Stack;

public class MaxTwinSumOfLinkedList {
    public int pairSum(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode node = head;
        while(node != null) {
            stack.add(node.val);
            node = node.next;
        }
        int n = stack.size();
        int sum = Integer.MIN_VALUE;
        node = head;
        for(int i = 0; i< n; i++) {
            sum = Math.max(sum, node.val + stack.pop());
            node = node.next;
        }
        return sum;
    }
}
