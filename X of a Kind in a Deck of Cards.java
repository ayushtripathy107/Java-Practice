import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        // Step 1: Count the frequency of each card
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int card : deck) {
            countMap.put(card, countMap.getOrDefault(card, 0) + 1);
        }

        // Step 2: Find the GCD of all frequencies
        int g = -1;
        for (int count : countMap.values()) {
            if (g == -1) {
                g = count;
            } else {
                g = gcd(g, count);
            }
        }

        // Step 3: Check if the common group size X is at least 2
        return g >= 2;
    }

    // Helper method to find the greatest common divisor using Euclidean algorithm
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
