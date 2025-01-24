import com.sun.source.tree.Tree;

public class GoodNodes {
    private int dfs(TreeNode root, int max) {
        if(root == null) return 0;
        int ans = 0;
        if(root.val >= max) ans++;
        ans += dfs(root.left, Math.max(max, root.val));
        ans += dfs(root.right, Math.max(max, root.val));
        return ans;
    }
    public int goodNodes(TreeNode root) {
        int max = Integer.MIN_VALUE;
        return dfs(root, max);
    }
}
