class Solution {
    public String sortString(String s) {
        // Count the frequency of each character
        int[] counts = new int[26];
        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }
        
        StringBuilder result = new StringBuilder();
        int totalChars = s.length();
        
        // Loop until all characters are appended to the result
        while (result.length() < totalChars) {
            // Step 1-3: Append available characters from 'a' to 'z'
            for (int i = 0; i < 26; i++) {
                if (counts[i] > 0) {
                    result.append((char) (i + 'a'));
                    counts[i]--;
                }
            }
            
            // Step 4-6: Append available characters from 'z' to 'a'
            for (int i = 25; i >= 0; i--) {
                if (counts[i] > 0) {
                    result.append((char) (i + 'a'));
                    counts[i]--;
                }
            }
        }
        
        return result.toString();
    }
}
