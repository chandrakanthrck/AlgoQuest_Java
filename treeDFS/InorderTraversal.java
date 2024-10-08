package treeDFS;

import treeBFS.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderHelper(root, result);
        return result;
    }

    private void inorderHelper(TreeNode root, List<Integer> result) {
        if (root == null) return;
        inorderHelper(root.left, result);
        result.add(root.val);  // Process the current node
        inorderHelper(root.right, result);
    }
}
