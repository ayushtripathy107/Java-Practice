class Solution {
    public int maxProfit(int[] prices) {
        // Track the lowest price seen so far
        int minPrice = Integer.MAX_VALUE;
        // Track the maximum profit found
        int maxProfit = 0;
        
        for (int price : prices) {
            if (price < minPrice) {
                // Update the minimum price
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                // Calculate profit and update if it's the highest so far
                maxProfit = price - minPrice;
            }
        }
        
        return maxProfit;
    }
}
