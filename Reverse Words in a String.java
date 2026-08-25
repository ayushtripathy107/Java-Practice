class Solution {
    public String reverseWords(String s) {
        // Step 1: Remove leading/trailing spaces and split by one or more spaces
        String[] words = s.trim().split("\\s+");
        
        // Step 2: Use StringBuilder to efficiently reconstruct the string
        StringBuilder reversed = new StringBuilder();
        
        // Step 3: Loop backwards through the words array
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            
            // Append a space between words, but not after the last word
            if (i > 0) {
                reversed.append(" ");
            }
        }
        
        return reversed.toString();
    }
}
