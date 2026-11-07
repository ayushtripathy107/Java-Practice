class Solution {
    public boolean checkRecord(String s) {
        // Condition 1: Less than 2 'A's total
        // Condition 2: Does not contain "LLL" (3 or more consecutive 'L's)
        return s.indexOf('A') == s.lastIndexOf('A') && !s.contains("LLL");
    }
}
