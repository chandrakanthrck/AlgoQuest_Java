package doordash.recursion;

public class LowestCommonAncestor {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root; // Return the current node if it matches p or q, or if it's null
        }

        // Recur on left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If both left and right are non-null, current node is the LCA
        if (left != null && right != null) {
            return root;
        }

        // Otherwise, return the non-null child (could be null if no LCA found)
        return left != null ? left : right;
    }

    public static void main(String[] args) {
        // Example Binary Tree:
        //         3
        //        / \
        //       5   1
        //      / \ / \
        //     6  2 0  8
        //       / \
        //      7   4
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        LowestCommonAncestor solver = new LowestCommonAncestor();

        TreeNode p = root.left; // Node 5
        TreeNode q = root.left.right.right; // Node 4
        TreeNode lca = solver.lowestCommonAncestor(root, p, q);

        System.out.println("LCA of " + p.val + " and " + q.val + " is: " + lca.val); // Output: 5
    }
}

