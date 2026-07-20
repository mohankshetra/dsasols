class Solution {

    public int countNodes(TreeNode root) {

        if (root == null)
            return 0;

        int leftHeight = leftHeight(root);
        int rightHeight = rightHeight(root);

        if (leftHeight == rightHeight)
            return (1 << leftHeight) - 1;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int leftHeight(TreeNode node) {
        int h = 0;

        while (node != null) {
            h++;
            node = node.left;
        }

        return h;
    }

    private int rightHeight(TreeNode node) {
        int h = 0;

        while (node != null) {
            h++;
            node = node.right;
        }

        return h;
    }
}