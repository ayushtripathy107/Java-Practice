class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        
        while (columnNumber > 0) {
            // Decrement to handle 1-based indexing (A=1 becomes 0)
            columnNumber--;
            
            // Get the remainder (0-25) and convert to char ('A' + remainder)
            char c = (char) ('A' + (columnNumber % 26));
            sb.append(c);
            
            // Move to the next "digit"
            columnNumber /= 26;
        }
        
        // The characters are added in reverse order
        return sb.reverse().toString();
    }
}
