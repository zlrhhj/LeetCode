

public class DiameterOfBinaryTree {
    private int diameter = 0;
    private int height(TreeNode node) {
        if(node == null) return 0;
        int left = height(node.left);
        int right = height(node.right);
        diameter = Math.max(left + right, diameter);
        return Math.max(left, right) + 1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }

}
