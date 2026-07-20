class Solution {
    public int[] countBits(int n) {
        // Create an array of size n + 1
        int[] ans = new int[n + 1];
        
        // Base case: ans[0] is already 0 by default
        for (int i = 1; i <= n; i++) {
            // ans[i / 2] + 1 if i is odd, or + 0 if i is even
            ans[i] = ans[i >> 1] + (i & 1);
        }
        
        return ans;
    }
}
