import com.sun.source.tree.Tree;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {

    }
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
public class ReverseOddLevelsBinaryTree {
    public TreeNode reverseOddLevel(TreeNode root) {
        traverseDFS(root.left, root.right, 0);
        return root;
    }
    private void traverseDFS(TreeNode left, TreeNode right, int level) {
        if(right == null || left == null) {
            return;
        }
        if(level % 2 == 0) {
            int temp = right.val;
            right.val = left.val;
            left.val = temp;
        }
        traverseDFS(left.left, right.right, level + 1);
        traverseDFS(left.right, right.left, level + 1);
    }
}
