class Solution {

    private int k;
    private int answer;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        inorder(root);
        return answer;
    }

    private void inorder(TreeNode node) {

        if (node == null)
            return;

        inorder(node.left);

        k--;

        if (k == 0) {
            answer = node.val;
            return;
        }

        inorder(node.right);
    }
}