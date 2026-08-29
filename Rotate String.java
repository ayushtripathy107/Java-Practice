class Solution {
    public boolean rotateString(String s, String goal) {
        // If lengths are different, s can never become goal
        if (s.length() != goal.length()) {
            return false;
        }
        
        // All rotations of s are substrings of s + s
        String doubledS = s + s;
        return doubledS.contains(goal);
    }
}
