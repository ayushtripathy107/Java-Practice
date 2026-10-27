class Solution {
    public int projectionArea(int[][] grid) {
        int n = grid.length;
        int totalArea = 0;
        
        for (int i = 0; i < n; i++) {
            int maxRow = 0;
            int maxCol = 0;
            
            for (int j = 0; j < n; j++) {
                // 1. Top View (xy-plane)
                if (grid[i][j] > 0) {
                    totalArea++;
                }
                
                // 2. Front View (zx-plane) -> Maximum of current row
                maxRow = Math.max(maxRow, grid[i][j]);
                
                // 3. Side View (yz-plane) -> Maximum of current column
                maxCol = Math.max(maxCol, grid[j][i]);
            }
            
            // Add the max heights of the row and column to the total area
            totalArea += maxRow;
            totalArea += maxCol;
        }
        
        return totalArea;
    }
}
