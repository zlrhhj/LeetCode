import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelSum {
    public int maxLevelSum(TreeNode root) {
        int result = 0, level = 0;
        int max = Integer.MIN_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        while(!queue.isEmpty()) {
            level++;
            int len = queue.size();
            int sum = 0;
            for(int i = 0; i < len; i++) {
                TreeNode node = queue.remove();
                sum += node.val;
                if(node.right != null) queue.add(node.right);
                if(node.left != null) queue.add(node.left);
            }
            if(sum > max) {
                max = sum;
                result = level;
            }
        }
        return result;
    }
}
