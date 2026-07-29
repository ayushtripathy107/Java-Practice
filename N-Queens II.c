#include <stdio.h>

void backtrack(int row, int n, int cols, int diag1, int diag2, int* count) {
    // Base case: All queens are successfully placed
    if (row == n) {
        (*count)++;
        return;
    }

    // A bitmask representing all available positions in the current row
    // (cols | diag1 | diag2) sets bits to 1 where a queen attacks
    // Inverting it (~...) makes 1 represent a safe spot
    // Finally, '& ((1 << n) - 1)' limits the mask to the board width 'n'
    int availablePositions = ((1 << n) - 1) & ~(cols | diag1 | diag2);

    while (availablePositions > 0) {
        // Extract the lowest set bit (the first available safe column position)
        int position = availablePositions & -availablePositions;
        
        // Remove this position from available options
        availablePositions -= position;

        // Recursively move to the next row, updating the attack zones
        // Shift diag1 right and diag2 left to match their diagonal paths on the next row
        backtrack(row + 1, n, cols | position, (diag1 | position) >> 1, (diag2 | position) << 1, count);
    }
}

int totalNQueens(int n) {
    int count = 0;
    backtrack(0, n, 0, 0, 0, &count);
    return count;
}
