class Solution {
    public String largestOddNumber(String num) {
        // Scan from right to left to find the first odd digit
        for (int i = num.length() - 1; i >= 0; i--) {
            char c = num.charAt(i);
            // Check if the character represents an odd number
            if (c == '1' || c == '3' || c == '5' || c == '7' || c == '9') {
                return num.substring(0, i + 1);
            }
        }
        // Return empty string if no odd digit is found
        return "";
    }
}
