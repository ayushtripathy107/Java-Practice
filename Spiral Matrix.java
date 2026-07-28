import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        
        // Edge case: check for empty matrix
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        
        // Initialize boundaries
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        
        // Loop until boundaries cross over each other
        while (top <= bottom && left <= right) {
            
            // 1. Move from left to right along the top boundary
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++; // Row is fully visited, move top boundary down
            
            // 2. Move from top to bottom along the right boundary
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--; // Column is fully visited, move right boundary left
            
            // 3. Move from right to left along the bottom boundary
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--; // Row is fully visited, move bottom boundary up
            }
            
            // 4. Move from bottom to top along the left boundary
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++; // Column is fully visited, move left boundary right
            }
        }
        
        return result;
    }
}
