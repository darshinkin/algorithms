package yandex;

/**
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,2,3,4,4,3]
 * Output: true
 * Example 2:
 *
 *
 * Input: root = [1,2,2,null,3,null,3]
 * Output: false
 */

public class SymmetricTree {

    public static void main(String[] args) {
        boolean result = new SymmetricTree().isSymmetric(null);
        System.out.println(result);
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    boolean isMirror(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return true;
        }
        if(left == null || right == null) {
            return false;
        }
        return left.val == right.val && isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
