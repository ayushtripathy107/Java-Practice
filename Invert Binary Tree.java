class Solution {
    public TreeNode invertTree(TreeNode root) {
        // Base case: if the node is null, we've reached the end of a branch
        if (root == null) {
            return null;
        }

        // Swap the left and right children
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recursively call the function on the children
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
