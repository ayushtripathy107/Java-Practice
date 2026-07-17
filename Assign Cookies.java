import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        // Sort both greed factors and cookie sizes
        Arrays.sort(g);
        Arrays.sort(s);
        
        int childIndex = 0;
        int cookieIndex = 0;
        
        // Loop until we run out of children or cookies
        while (childIndex < g.length && cookieIndex < s.length) {
            // If the cookie satisfies the child's greed
            if (s[cookieIndex] >= g[childIndex]) {
                childIndex++; // Move to the next child
            }
            cookieIndex++; // Always move to the next cookie
        }
        
        // The childIndex represents the total number of content children
        return childIndex;
    }
}
