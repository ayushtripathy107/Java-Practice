import java.util.Arrays;

class Solution {
    public String largestNumber(int[] nums) {
        // Convert the integer array to a String array
        String[] asStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            asStrs[i] = String.valueOf(nums[i]);
        }

        // Sort using a custom comparator
        Arrays.sort(asStrs, (a, b) -> (b + a).compareTo(a + b));

        // If the largest number is "0", the entire result is "0"
        if (asStrs[0].equals("0")) {
            return "0";
        }

        // Build the final largest number string
        StringBuilder largestNumberStr = new StringBuilder();
        for (String numAsStr : asStrs) {
            largestNumberStr.append(numAsStr);
        }

        return largestNumberStr.toString();
    }
}
