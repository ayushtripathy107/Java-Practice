class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] counts = new int[101]; // Since 1 <= nums[i] <= 100
        int goodPairs = 0;
        
        for (int num : nums) {
            // The current number can form a pair with every previous occurrence of itself
            goodPairs += counts[num];
            // Update the count of this number
            counts[num]++;
        }
        
        return goodPairs;
    }
}
