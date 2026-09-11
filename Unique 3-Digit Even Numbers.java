class Solution {
    public int totalNumbers(int[] digits) {
        int[] freq = new int[10];
        for (int d : digits) {
            freq[d]++;
        }
        
        int count = 0;
        
        // Iterate through all possible 3-digit even numbers
        for (int i = 100; i < 1000; i += 2) {
            int d1 = i / 100;       // Hundreds digit
            int d2 = (i / 10) % 10; // Tens digit
            int d3 = i % 10;        // Ones digit
            
            // Temporarily decrement digit frequencies
            freq[d1]--;
            freq[d2]--;
            freq[d3]--;
            
            // Check if we have enough of each digit available
            if (freq[d1] >= 0 && freq[d2] >= 0 && freq[d3] >= 0) {
                count++;
            }
            
            // Restore frequencies for the next iteration
            freq[d1]++;
            freq[d2]++;
            freq[d3]++;
        }
        
        return count;
    }
}
