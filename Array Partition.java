import java.util.Arrays;

class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int maxSum = 0;
        
        // Sum up elements at even indices
        for (int i = 0; i < nums.length; i += 2) {
            maxSum += nums[i];
        }
        
        return maxSum;
    }
}
