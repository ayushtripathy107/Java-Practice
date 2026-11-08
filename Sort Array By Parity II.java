class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int even = 0;
        int odd = 1;
        int n = nums.length;
        
        while (even < n && odd < n) {
            // Find the first misplaced odd number at an even index
            while (even < n && nums[even] % 2 == 0) {
                even += 2;
            }
            // Find the first misplaced even number at an odd index
            while (odd < n && nums[odd] % 2 != 0) {
                odd += 2;
            }
            
            // Swap them if both pointers are still within the bounds
            if (even < n && odd < n) {
                int temp = nums[even];
                nums[even] = nums[odd];
                nums[odd] = temp;
                
                even += 2;
                odd += 2;
            }
        }
        
        return nums;
    }
}
