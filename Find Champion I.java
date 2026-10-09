class Solution {
    public int findChampion(int[][] grid) {
        int n = grid.length;
        
        // Check each team to see if it is a champion
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
            // If team i is stronger than all other n - 1 teams
            if (count == n - 1) {
                return i;
            }
        }
        
        return -1;
    }
}
