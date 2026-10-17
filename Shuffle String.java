class Solution {
    public String restoreString(String s, int[] indices) {
        // Create a character array of the same length
        char[] shuffled = new char[s.length()];
        
        // Place each character at its target index
        for (int i = 0; i < s.length(); i++) {
            shuffled[indices[i]] = s.charAt(i);
        }
        
        // Convert the character array back to a String
        return new String(shuffled);
    }
}
