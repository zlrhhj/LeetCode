import com.sun.source.tree.Tree;

public class SubtreeOfAnotherTree {
    private boolean equals(TreeNode t1, TreeNode t2) {
        if(t1 == null || t2 == null) {
            return t1 == null && t2 == null;
        }
        return t1.val == t2.val && equals(t1.left, t2.left) && equals(t1.right, t2.right);
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return equals(root, subRoot) || (root != null && (isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)));
    }
}
