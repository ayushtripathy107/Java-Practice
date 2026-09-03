import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] separateDigits(int[] nums) {
        // Use a dynamic list to store individual digits
        List<Integer> digitList = new ArrayList<>();
        
        // Process each number in the input array
        for (int num : nums) {
            // Convert number to string to easily access digits from left to right
            String numStr = Integer.toString(num);
            for (int i = 0; i < numStr.length(); i++) {
                digitList.add(numStr.charAt(i) - '0');
            }
        }
        
        // Convert the List back into a primitive int array
        int[] result = new int[digitList.size()];
        for (int i = 0; i < digitList.size(); i++) {
            result[i] = digitList.get(i);
        }
        
        return result;
    }
}
