class Solution {
    public boolean isCircularSentence(String sentence) {
        // Step 1: Check the circular condition for the first and last character
        if (sentence.charAt(0) != sentence.charAt(sentence.length() - 1)) {
            return false;
        }
        
        // Step 2: Check adjacent characters around every space
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == ' ') {
                if (sentence.charAt(i - 1) != sentence.charAt(i + 1)) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
