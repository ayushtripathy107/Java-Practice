class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int countL = 0;
        int countR = 0;
        int countBlank = 0;
        
        // Count each character in the moves string
        for (char ch : moves.toCharArray()) {
            if (ch == 'L') {
                countL++;
            } else if (ch == 'R') {
                countR++;
            } else {
                countBlank++;
            }
        }
        
        // Net distance from L and R + all flexible underscore moves
        return Math.abs(countL - countR) + countBlank;
    }
}
