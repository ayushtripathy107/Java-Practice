class Solution {
    public int[] shuffle(int[] nums, int n) {
        // Create a new array to store the shuffled elements
        int[] result = new int[2 * n];
        
        // Loop through the first half of the array (x elements)
        for (int i = 0; i < n; i++) {
            // Place x_i at even indices: 0, 2, 4, ...
            result[2 * i] = nums[i];
            // Place y_i at odd indices: 1, 3, 5, ...
            result[2 * i + 1] = nums[i + n];
        }
        
        return result;
    }
}
