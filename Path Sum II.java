import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        dfs(root, targetSum, currentPath, result);
        return result;
    }

    private void dfs(TreeNode node, int remainingSum, List<Integer> currentPath, List<List<Integer>> result) {
        if (node == null) {
            return;
        }

        // Include current node in the path
        currentPath.add(node.val);

        // Check if it's a leaf node and satisfies the remaining sum
        if (node.left == null && node.right == null && remainingSum == node.val) {
            result.add(new ArrayList<>(currentPath)); // Create a deep copy of the valid path
        } else {
            // Recurse into children with updated sum
            dfs(node.left, remainingSum - node.val, currentPath, result);
            dfs(node.right, remainingSum - node.val, currentPath, result);
        }

        // Backtrack: remove the current node before popping out of the recursion stack
        currentPath.remove(currentPath.size() - 1);
    }
}
