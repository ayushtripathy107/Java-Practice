import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        // An IP address has 4 segments of max 3 digits each = 12 digits max.
        if (s == null || s.length() < 4 || s.length() > 12) {
            return result;
        }
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int start, List<String> current, List<String> result) {
        // Base case: If we have 4 segments and reached the end of the string
        if (current.size() == 4) {
            if (start == s.length()) {
                result.add(String.join(".", current));
            }
            return;
        }

        // Try lengths from 1 to 3 for the current segment
        for (int len = 1; len <= 3; len++) {
            if (start + len > s.length()) {
                break;
            }

            String segment = s.substring(start, start + len);

            // Check for leading zeros: length > 1 and starts with '0' is invalid
            if (segment.length() > 1 && segment.charAt(0) == '0') {
                break; 
            }

            // Check if value is within valid IP segment range [0, 255]
            int val = Integer.parseInt(segment);
            if (val > 255) {
                break;
            }

            // Choose
            current.add(segment);
            // Explore
            backtrack(s, start + len, current, result);
            // Unchoose (Backtrack)
            current.remove(current.size() - 1);
        }
    }
}
