public class LongestZigZag {
    private int maxStep = 0;
    private void dfs(TreeNode node, boolean goLeft, int steps) {
        if(node == null) return;
        maxStep = Math.max(maxStep, steps);
        if(goLeft) {
            dfs(node.left, false, steps + 1);
            dfs(node.right, true, 1);
        } else {
            dfs(node.right, true, steps + 1);
            dfs(node.left, false, 1);
        }
    }
    public int longestZigZag(TreeNode root) {
        dfs(root, true, 0);
        dfs(root, false, 0);
        return maxStep;
    }
}
