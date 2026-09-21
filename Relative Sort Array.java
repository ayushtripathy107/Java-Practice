import java.util.Arrays;

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // Step 1: Count occurrences of each number in arr1
        int[] count = new int[1001];
        for (int num : arr1) {
            count[num]++;
        }
        
        int index = 0;
        
        // Step 2: Place elements of arr2 in the correct relative order
        for (int num : arr2) {
            while (count[num] > 0) {
                arr1[index++] = num;
                count[num]--;
            }
        }
        
        // Step 3: Place the remaining elements in ascending order
        for (int num = 0; num < count.length; num++) {
            while (count[num] > 0) {
                arr1[index++] = num;
                count[num]--;
            }
        }
        
        return arr1;
    }
}
