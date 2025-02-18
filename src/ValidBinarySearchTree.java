import java.util.Stack;

public class ValidBinarySearchTree {
    private Stack<Integer> stack = new Stack<>();
    public boolean isValidBST(TreeNode root) {
        boolean res = true;
        if(root == null) return true;
        res = res && isValidBST(root.left);
        if(stack.size() > 0 && stack.peek() >= root.val) return false;
        stack.add(root.val);
        res = res && isValidBST(root.right);
        return res;
    }
}
