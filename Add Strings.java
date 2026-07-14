class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;

        // Iterate while there are digits left or a carry to process
        while (i >= 0 || j >= 0 || carry != 0) {
            // Get value of current digit, or 0 if index is out of bounds
            int n1 = (i >= 0) ? num1.charAt(i) - '0' : 0;
            int n2 = (j >= 0) ? num2.charAt(j) - '0' : 0;

            // Calculate sum and carry
            int sum = n1 + n2 + carry;
            res.append(sum % 10);
            carry = sum / 10;

            i--;
            j--;
        }

        // Reverse the result since we appended from right to left
        return res.reverse().toString();
    }
}
