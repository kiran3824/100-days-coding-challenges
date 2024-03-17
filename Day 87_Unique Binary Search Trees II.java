/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new ArrayList<TreeNode>();
        return helper(1, n);
    }

    List<TreeNode> helper(int s, int e) {
        List<TreeNode> result = new ArrayList<>();
        if (s > e) {
            result.add(null);
            return result;
        }
        for (int i = s; i <= e; i++) {
            List<TreeNode> leftSubtrees = helper(s, i - 1);
            List<TreeNode> rightSubtrees = helper(i + 1, e);
            for (TreeNode left : leftSubtrees) {
                for (TreeNode right : rightSubtrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }
        return result;
    }
}
