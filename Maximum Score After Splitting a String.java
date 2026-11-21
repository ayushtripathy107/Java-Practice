class Solution {
    public int maxScore(String s) {
        int rightOnes = 0;
        // Count total '1's in the string
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                rightOnes++;
            }
        }

        int leftZeros = 0;
        int maxScore = 0;

        // Iterate up to length - 2 so both substrings remain non-empty
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                leftZeros++;
            } else {
                rightOnes--;
            }
            maxScore = Math.max(maxScore, leftZeros + rightOnes);
        }

        return maxScore;
    }
}
