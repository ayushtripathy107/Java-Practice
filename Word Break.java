import java.util.*;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // Convert list to set for fast O(1) lookups
        Set<String> wordSet = new HashSet<>(wordDict);
        int n = s.length();
        
        // dp[i] means s.substring(0, i) can be segmented
        boolean[] dp = new boolean[n + 1];
        dp[0] = true; // Base case: empty string
        
        // Iterate through all lengths of the substring
        for (int i = 1; i <= n; i++) {
            // Check all possible split points
            for (int j = 0; j < i; j++) {
                // If the prefix can be segmented and the remaining suffix is in the dictionary
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // Found a valid segmentation for length i, move to next length
                }
            }
        }
        
        return dp[n];
    }
}
