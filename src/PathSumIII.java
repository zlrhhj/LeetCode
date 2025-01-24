public class PathSumIII {
    private int pathSum_a (TreeNode node, long targetSum) {
        if(node == null) return 0;
        int res = 0;
        if(node.val == targetSum) res++;
        res += pathSum_a(node.left, targetSum - node.val);
        res += pathSum_a(node.right, targetSum - node.val);
        return res;
    }
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
        return pathSum(root.left, targetSum) + pathSum_a(root, targetSum) + pathSum(root.right, targetSum);
    }
}
