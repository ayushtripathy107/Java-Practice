import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Sort to handle duplicates easily
        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentSubset, int[] nums, int start) {
        // Add the copy of the current subset to the result
        result.add(new ArrayList<>(currentSubset));

        for (int i = start; i < nums.length; i++) {
            // Skip duplicates: skip if current element is same as previous, 
            // but only if it's not the starting element of this recursion level
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            
            // Include the element
            currentSubset.add(nums[i]);
            
            // Move to the next element
            backtrack(result, currentSubset, nums, i + 1);
            
            // Backtrack: remove the element
            currentSubset.remove(currentSubset.size() - 1);
        }
    }
}
