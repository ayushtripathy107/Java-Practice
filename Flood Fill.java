class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // Store the original color of the starting pixel
        int originalColor = image[sr][sc];
        
        // If the starting pixel already has the target color, no changes are needed
        if (originalColor != color) {
            dfs(image, sr, sc, originalColor, color);
        }
        
        return image;
    }
    
    private void dfs(int[][] image, int r, int c, int originalColor, int newColor) {
        // Check boundary conditions
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length) {
            return;
        }
        
        // If the current pixel does not match the original starting color, skip it
        if (image[r][c] != originalColor) {
            return;
        }
        
        // Update the pixel color
        image[r][c] = newColor;
        
        // Recursively visit all 4 neighboring directions
        dfs(image, r + 1, c, originalColor, newColor); // Down
        dfs(image, r - 1, c, originalColor, newColor); // Up
        dfs(image, r, c + 1, originalColor, newColor); // Right
        dfs(image, r, c - 1, originalColor, newColor); // Left
    }
}
