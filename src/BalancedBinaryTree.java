public class BalancedBinaryTree {
    private int heights(TreeNode root) {
        if(root == null) return 0;
        int leftHeights = heights(root.left);
        int rightHeights = heights(root.right);
        if(leftHeights == -1 || rightHeights == -1 ){
            return -1;
        }
        if(Math.abs(leftHeights - rightHeights) <= 1)
            return Math.max(leftHeights,rightHeights) + 1;
        else return -1;
    }
    public boolean isBalanced(TreeNode root) {
        return heights(root) != -1;
    }
}
