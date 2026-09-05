class Solution(object):
    def rotateGrid(self, grid, k):
        """
        :type grid: List[List[int]]
        :type k: int
        :rtype: List[List[int]]
        """
        m = len(grid)
        n = len(grid[0])
        
        # Determine the number of layers in the grid
        num_layers = min(m, n) // 2
        
        for layer in range(num_layers):
            # Define the boundaries of the current layer
            top = layer
            bottom = m - 1 - layer
            left = layer
            right = n - 1 - layer
            
            # 1. Extract elements of the current layer in counter-clockwise order
            layer_elements = []
            
            # Top row (left to right)
            for j in range(left, right):
                layer_elements.append(grid[top][j])
            # Right column (top to bottom)
            for i in range(top, bottom):
                layer_elements.append(grid[i][right])
            # Bottom row (right to left)
            for j in range(right, left, -1):
                layer_elements.append(grid[bottom][j])
            # Left column (bottom to top)
            for i in range(bottom, top, -1):
                layer_elements.append(grid[i][left])
                
            # 2. Optimize rotation using modulo arithmetic
            length = len(layer_elements)
            effective_k = k % length
            
            # Counter-clockwise rotation shifts elements forward by effective_k
            rotated_elements = layer_elements[effective_k:] + layer_elements[:effective_k]
            
            # 3. Place the rotated elements back into the grid
            idx = 0
            
            # Top row (left to right)
            for j in range(left, right):
                grid[top][j] = rotated_elements[idx]
                idx += 1
            # Right column (top to bottom)
            for i in range(top, bottom):
                grid[i][right] = rotated_elements[idx]
                idx += 1
            # Bottom row (right to left)
            for j in range(right, left, -1):
                grid[bottom][j] = rotated_elements[idx]
                idx += 1
            # Left column (bottom to top)
            for i in range(bottom, top, -1):
                grid[i][left] = rotated_elements[idx]
                idx += 1
                
        return grid
