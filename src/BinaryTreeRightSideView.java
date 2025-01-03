import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){};
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class BinaryTreeRightSideView {
    List<Integer> result = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) {
            return null;
        }
        helper(root, 0);
        return result;
    }
    public void helper(TreeNode node, int level) {
       if(result.size() == level) {
           result.add(node.val);
       }
       if(node.right != null) {
           helper(node.right, level + 1);
       }
       if(node.left != null) {
           helper(node.left, level + 1);
       }
    }
}
