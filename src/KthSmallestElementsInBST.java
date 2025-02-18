import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementsInBST {
    List<Integer> list = new ArrayList<>();
    private void preOrder(TreeNode node) {
        if(node != null) {
            preOrder(node.left);
            list.add(node.val);
            preOrder(node.right);
        }
    }
    public int kthSmallest(TreeNode root, int k) {
        preOrder(root);
        return list.get(k - 1);
    }
}
