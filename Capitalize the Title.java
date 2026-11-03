class Solution {
    public String capitalizeTitle(String title) {
        // Split the string into individual words by spaces
        String[] words = title.split(" ");
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            
            // If the word has 1 or 2 letters, convert it completely to lowercase
            if (word.length() <= 2) {
                result.append(word.toLowerCase());
            } else {
                // Otherwise, capitalize the first letter and lowercase the rest
                result.append(Character.toUpperCase(word.charAt(0)));
                result.append(word.substring(1).toLowerCase());
            }
            
            // Append a space between words, but not after the last word
            if (i < words.length - 1) {
                result.append(" ");
            }
        }
        
        return result.toString();
    }
}
