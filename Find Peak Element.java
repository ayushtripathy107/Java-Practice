class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] < nums[mid + 1]) {
                // Move towards the higher element on the right
                left = mid + 1;
            } else {
                // The current mid could be a peak, or the peak is to the left
                right = mid;
            }
        }
        
        // 'left' and 'right' will converge to the index of a peak element
        return left;
    }
}
