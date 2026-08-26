class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0;
        int twos = 0;
        
        for (int num : nums) {
            // 'ones' holds bits that appeared 1 time (but not 3 times)
            ones = (ones ^ num) & ~twos;
            
            // 'twos' holds bits that appeared 2 times (but not 3 times)
            twos = (twos ^ num) & ~ones;
        }
        
        return ones;
    }
}
