class Solution {
    public boolean canReach(int[] start, int[] target) {
        // A knight always switches square color on every move.
        // Even moves require the start and target squares to have the same color.
        int startColor = (start[0] + start[1]) % 2;
        int targetColor = (target[0] + target[1]) % 2;
        
        return startColor == targetColor;
    }
}
