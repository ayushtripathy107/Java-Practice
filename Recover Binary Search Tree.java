class Solution {
    private TreeNode first = null;
    private TreeNode second = null;
    private TreeNode prev = null;

    public void recoverTree(TreeNode root) {
        // In-order traversal to find the two swapped nodes
        inorder(root);

        // Swap their values back
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }

    private void inorder(TreeNode node) {
        if (node == null) return;

        inorder(node.left);

        // Detect swapped nodes
        if (prev != null && prev.val > node.val) {
            if (first == null) {
                first = prev;
            }
            second = node;
        }
        prev = node;

        inorder(node.right);
    }
}
