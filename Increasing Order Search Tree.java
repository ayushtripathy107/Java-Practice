/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private TreeNode dummy = new TreeNode(0);
    private TreeNode current = dummy;

    public TreeNode increasingBST(TreeNode root) {
        inorder(root);
        return dummy.right;
    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        
        // 1. Traverse the left subtree
        inorder(node.left);
        
        // 2. Process the current node
        // Disconnect the left child to fulfill the "no left child" requirement
        node.left = null; 
        // Link the current tail of our new tree to this node
        current.right = node; 
        // Move the tail pointer forward
        current = node; 
        
        // 3. Traverse the right subtree
        inorder(node.right);
    }
}
