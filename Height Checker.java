import java.util.Arrays;

class Solution {
    public int heightChecker(int[] heights) {
        // 1. Create a copy of the original array
        int[] expected = heights.clone();
        
        // 2. Sort the copy to get the expected non-decreasing order
        Arrays.sort(expected);
        
        // 3. Compare original heights with the sorted expected heights
        int mismatchCount = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]) {
                mismatchCount++;
            }
        }
        
        return mismatchCount;
    }
}
