package Tree;

public class DiameterofBinaryTree {

    int ans = Integer.MIN_VALUE;

    public int diameterOfBinaryTree(TreeNode root) {
        check(root);
        return ans;
    }

    int check(TreeNode node) {
        if (node == null)
            return -1;

        int left = 1 + check(node.left);
        int right = 1 + check(node.right);

        ans = Math.max(ans, left + right);

        return Math.max(left, right);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        DiameterofBinaryTree obj = new DiameterofBinaryTree();

        int result = obj.diameterOfBinaryTree(root);

        System.out.println("Diameter = " + result);
    }
}