class Solution {
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    private boolean validate(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }

        // Check if current node violates min or max constraints
        if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
            return false;
        }

        // Left child must be < node.val, Right child must be > node.val
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }
}
