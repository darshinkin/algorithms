package cracking.tree;

public class FindMaxPathInTree {

    public static void main(String[] args) {
        Node root = new Node();
        int res = new FindMaxPathInTree().findMaxPath(root);
        System.out.println("Result: " + res);
    }

    private int findMaxPath(Node root) {
        if(root == null) {
            return 0;
        }
        int left = findMaxPath(root.left);
        int right = findMaxPath(root.right);
        return Math.max(left, right) + root.value;
    }

    static class Node {
        int value;
        Node left;
        Node right;
    }
}
