class Solution {
    public String thousandSeparator(int n) {
        String s = Integer.toString(n);
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            // Add a dot if it's not the first character and the remaining digits from the right is a multiple of 3
            if (i > 0 && (s.length() - i) % 3 == 0) {
                sb.append('.');
            }
            sb.append(s.charAt(i));
        }
        
        return sb.toString();
    }
}
