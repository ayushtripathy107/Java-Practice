class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root != null) {
            dfs(root, "", paths);
        }
        return paths;
    }

    private void dfs(TreeNode node, String path, List<String> paths) {
        // Append the current node's value to the path
        path += node.val;

        // If it's a leaf node, add the completed path to our list
        if (node.left == null && node.right == null) {
            paths.add(path);
        } else {
            // If not a leaf, add the arrow and continue to children
            path += "->";
            if (node.left != null) {
                dfs(node.left, path, paths);
            }
            if (node.right != null) {
                dfs(node.right, path, paths);
            }
        }
    }
}
