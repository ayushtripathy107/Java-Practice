class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        
        // If current node's value is out of bounds on the higher side,
        // search only the left subtree
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }
        
        // If current node's value is out of bounds on the lower side,
        // search only the right subtree
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }
        
        // Current node's value is within [low, high]
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }
}
