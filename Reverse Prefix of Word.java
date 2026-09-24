class Solution {
    public String reversePrefix(String word, char ch) {
        // Find the index of the first occurrence of ch
        int index = word.indexOf(ch);
        
        // If the character doesn't exist, return the original word
        if (index == -1) {
            return word;
        }
        
        // Extract the prefix, reverse it, and append the remaining part of the word
        String prefix = word.substring(0, index + 1);
        String remaining = word.substring(index + 1);
        
        return new StringBuilder(prefix).reverse().toString() + remaining;
    }
}
